package com.haedrig.order.domain.event;

import java.io.Serializable;

public class OrderClosedEvent implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private final String id;
	
	public OrderClosedEvent(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
