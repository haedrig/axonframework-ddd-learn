package com.haedrig.order.domain.command;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class CreateOrderCommand {
	
	@TargetAggregateIdentifier
	private final String id;
	
	public CreateOrderCommand(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

}
