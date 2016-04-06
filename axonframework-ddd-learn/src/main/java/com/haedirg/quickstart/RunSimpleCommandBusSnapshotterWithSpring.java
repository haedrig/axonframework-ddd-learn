package com.haedirg.quickstart;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunSimpleCommandBusSnapshotterWithSpring {

    public static void main(String[] args) throws InterruptedException {
        // Load the spring beans from the xml configuration file.
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("axon_simple.xml");

        // Obtain the gateway from the context to send commands.
        CommandGateway commandGateway = applicationContext.getBean("commandGateway", CommandGateway.class);

        // and let's send some Commands on the CommandBus.
        CommandGenerator.sendCommands(commandGateway);

        // close the application context
        //applicationContext.close();
    }
}
