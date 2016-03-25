package com.haedrig.order.domain.handler;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.haedrig.order.domain.Order;
import com.haedrig.order.domain.command.CloseCommand;
import com.haedrig.order.domain.command.CreateOrderCommand;
import com.haedrig.order.domain.command.LoadOrderCommand;

@Component
public class OrderCommandHandler {

	private Repository<Order> orderRepository;
	
	@Autowired
	private CommandGateway commandGateway;

	@Autowired
	public void setOrderRepository(Repository<Order> orderRepository) {
		this.orderRepository = orderRepository;
	}

	@CommandHandler
	public boolean create(CreateOrderCommand command) {
		Order order = new Order(command);
		orderRepository.add(order);
		
		//order.close(new CloseCommand(command.getId()));
		//commandGateway.sendAndWait(new CloseCommand(command.getId()));
		return true;
	}

	@CommandHandler
	public boolean close(CloseCommand command) {
		orderRepository.load(command.getId()).close(command);
		return true;
	}

	@CommandHandler
	public Order load(LoadOrderCommand command) {
		return orderRepository.load(command.getId());
	}

}
