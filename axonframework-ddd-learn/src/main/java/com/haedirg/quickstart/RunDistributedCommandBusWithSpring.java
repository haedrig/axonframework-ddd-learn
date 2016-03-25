package com.haedirg.quickstart;

import java.net.BindException;
import java.util.Scanner;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.jgroups.stack.GossipRouter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunDistributedCommandBusWithSpring {

    public static void main(String[] args) throws Exception {

    	
        // Start the GossipRouter if it is not already running
        GossipRouter gossipRouter = new GossipRouter();
        try {
            gossipRouter.start();
        } catch (BindException e) {
            System.out.println("Gossip router is already started in another JVM instance.");
        }
        
        
        System.setProperty("jgroups.bind_addr", args[0]);
        System.setProperty("jgroups.bind_port", args[1]);
        //System.setProperty("jgroups.tcpping.initial_hosts", args[2]);
        
        // Load the spring beans from the xml configuration file.
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("axon_distributed.xml");
        
        
        // Obtain the gateway from the context to send commands.
        CommandGateway commandGateway = applicationContext.getBean("commandGateway", CommandGateway.class);
        
        Scanner sc = new Scanner(System.in);
        boolean res = true;
        while (res) {
        	if (sc.nextLine().equals("0")) {
        		res=false;
			};
		}
        // and let's send some Commands on the CommandBus.
        CommandGenerator.sendCommands(commandGateway);

        // close the application context
        //applicationContext.close();
    }
}
