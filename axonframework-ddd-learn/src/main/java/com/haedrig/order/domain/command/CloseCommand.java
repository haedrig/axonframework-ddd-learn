package com.haedrig.order.domain.command;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class CloseCommand {

	@TargetAggregateIdentifier
	private final String id;
	
	public CloseCommand(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

}
