package com.haedrig.order.domain;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;

import com.haedrig.order.domain.command.CloseCommand;
import com.haedrig.order.domain.command.CreateOrderCommand;
import com.haedrig.order.domain.event.OrderClosedEvent;
import com.haedrig.order.domain.event.OrderCreatedEvent;

public class Order extends AbstractAnnotatedAggregateRoot<String> {

	private static final long serialVersionUID = 1L;

	@AggregateIdentifier
	private String id;
	
	private Integer status;

	protected Order() {

	}

	public Order(CreateOrderCommand command) {
		apply(new OrderCreatedEvent(command.getId()));
	}

	@EventSourcingHandler
	public void onCreate(OrderCreatedEvent event) {
		this.id = event.getId();
		this.status = 1;
	}
	
	
	public void close(CloseCommand command) {
		apply(new OrderClosedEvent(command.getId()));
	}

	@EventSourcingHandler
	public void onCreate(OrderClosedEvent event) {
		this.status = 0;
	}
	

	public String getId() {
		return id;
	}

	public Integer getStatus() {
		return status;
	}



}