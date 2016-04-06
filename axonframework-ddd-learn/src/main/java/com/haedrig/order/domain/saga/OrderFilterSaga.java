package com.haedrig.order.domain.saga;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.annotation.Timestamp;
import org.axonframework.eventhandling.scheduling.EventScheduler;
import org.axonframework.eventhandling.scheduling.ScheduleToken;
import org.axonframework.saga.annotation.AbstractAnnotatedSaga;
import org.axonframework.saga.annotation.SagaEventHandler;
import org.axonframework.saga.annotation.StartSaga;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.springframework.beans.factory.annotation.Autowired;

import com.haedrig.order.domain.command.CloseCommand;
import com.haedrig.order.domain.event.OrderClosedEvent;
import com.haedrig.order.domain.event.OrderCreatedEvent;

public class OrderFilterSaga extends AbstractAnnotatedSaga {

	private static final long serialVersionUID = 1L;

	public static final Long FILTER_AFTER_MILLIS = new Long(
			DateTimeConstants.MILLIS_PER_SECOND * 60 * 1);

	@Autowired
	private transient CommandGateway commandGateway;
	@Autowired
	private transient EventScheduler eventScheduler;

	private ScheduleToken deadline;

	@StartSaga
	@SagaEventHandler(associationProperty = "id")
	public void handle(OrderCreatedEvent event, @Timestamp DateTime eventTime) {
		deadline = eventScheduler.schedule(
				getFutureTime(eventTime, FILTER_AFTER_MILLIS),
				new OrderFilterSagaEvent(event.getId()));
	}

	@SagaEventHandler(associationProperty = "id")
	public void handle(OrderClosedEvent event) {
		System.out.println("Order closed saga");
		if (deadline != null) {
			eventScheduler.cancelSchedule(deadline);
		}
		end();
	}

	protected DateTime getFutureTime(DateTime eventTime, Long TIME_AFTER_MILLIS) {
		DateTime returnDateTime = new DateTime(eventTime.getMillis()
				+ TIME_AFTER_MILLIS);
		return returnDateTime;
	}

	@SagaEventHandler(associationProperty = "id")
	public void handle(OrderFilterSagaEvent event) {
		commandGateway.send(new CloseCommand(event.getId()));
	}

}