package com.haedrig.order.domain.command;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class LoadOrderCommand {

	@TargetAggregateIdentifier
	private final String id;

	public LoadOrderCommand(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
}
