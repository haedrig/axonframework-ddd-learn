package com.haedrig.order.domain.handler;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.haedrig.order.domain.command.CloseCommand;
import com.haedrig.order.domain.command.LoadOrderCommand;
import com.haedrig.order.domain.event.OrderClosedEvent;
import com.haedrig.order.domain.event.OrderCreatedEvent;


@Component
public class OrderEventListener {
	
	@Autowired
	private CommandGateway commandGateway;

	
	@EventHandler
	public void handleCreate(OrderCreatedEvent event) {
		//System.out.println("OrderCreatedEvent");
		
		//commandGateway.sendAndWait(new LoadOrderCommand(event.getId()));
	}
	
	@EventHandler
	public void handleClose(OrderClosedEvent event) {
//		System.out.println("OrderClosedEvent");
	}
	
}
