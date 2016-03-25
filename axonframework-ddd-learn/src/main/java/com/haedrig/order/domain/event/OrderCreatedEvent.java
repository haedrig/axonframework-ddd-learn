package com.haedrig.order.domain.event;

import java.io.Serializable;

public class OrderCreatedEvent implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	public OrderCreatedEvent() {
	}
    
	public OrderCreatedEvent(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
}
