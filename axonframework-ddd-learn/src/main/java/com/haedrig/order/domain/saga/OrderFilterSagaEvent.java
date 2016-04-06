package com.haedrig.order.domain.saga;

import java.io.Serializable;

public class OrderFilterSagaEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	public OrderFilterSagaEvent(String id) {
		this.setId(id);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	
}
