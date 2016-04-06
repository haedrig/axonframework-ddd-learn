package com.haedrig.order.domain.event;

import java.io.Serializable;

public class OrderClosedEvent implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	public OrderClosedEvent() {
		
	}
	
	public OrderClosedEvent(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
