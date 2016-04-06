package com.haedirg.quickstart;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xiaohanghu.stresstester.StressTestUtils;
import org.xiaohanghu.stresstester.core.StressResult;
import org.xiaohanghu.stresstester.core.StressTask;

import com.eaio.uuid.UUID;
import com.haedrig.order.domain.Order;
import com.haedrig.order.domain.command.CloseCommand;
import com.haedrig.order.domain.command.CreateOrderCommand;
import com.haedrig.order.domain.command.LoadOrderCommand;

public class RunSimpleCommandBusWithSpring {

    public static void main(String[] args) throws InterruptedException {
        // Load the spring beans from the xml configuration file.
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("axon_simple.xml");

        // Obtain the gateway from the context to send commands.
        final CommandGateway commandGateway = applicationContext.getBean("commandGateway", CommandGateway.class);

//        // and let's send some Commands on the CommandBus.
//        CommandGenerator.sendCommands(commandGateway);
        
        
        
    	final String itemId1 = new UUID().toString();
		commandGateway.sendAndWait(new CreateOrderCommand(itemId1));
		
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
        
        //final String itemId1 = "003186e0-f576-11e5-8e7e-0862664b6c42";
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		commandGateway.sendAndWait(new CloseCommand(itemId1));
//		
//        
//		Order order =  commandGateway.sendAndWait(new LoadOrderCommand(itemId1));
//		
//		System.out.println(itemId1);
//		System.out.println(order.getCount());
//		
    	StressResult result = StressTestUtils.test(100, 100, new StressTask() {
			
			public Object doTask() {
//				Order order =  commandGateway.sendAndWait(new LoadOrderCommand(itemId1));
				//System.out.println(order.getId());
				try {
					//final String itemId1 = new UUID().toString();
					commandGateway.sendAndWait(new CloseCommand(itemId1));
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return null;
			}
		});
//    	
    	System.out.println(StressTestUtils.format(result));
    	
		Order order =  commandGateway.sendAndWait(new LoadOrderCommand(itemId1));
		
		System.out.println(itemId1);
		System.out.println(order.getCount());
    	
    	
//		StressResult result = StressTestUtils.test(1000, 10000, new StressTask() {
//			
//			public Object doTask() {
////				Order order =  commandGateway.sendAndWait(new LoadOrderCommand(itemId1));
//				//System.out.println(order.getId());
//				try {
//					//final String itemId1 = new UUID().toString();
//					Order order = commandGateway.sendAndWait(new LoadOrderCommand(itemId1));
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				
//				return null;
//			}
//		});
////    	
//    	System.out.println(StressTestUtils.format(result));
    	
//
//        // close the application context
//        //applicationContext.close();
        
        
    }
}
