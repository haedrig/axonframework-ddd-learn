/*
 * Copyright (c) 2010-2014. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haedirg.quickstart;


import org.axonframework.commandhandling.callbacks.FutureCallback;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.xiaohanghu.stresstester.StressTestUtils;
import org.xiaohanghu.stresstester.core.StressResult;
import org.xiaohanghu.stresstester.core.StressTask;

import com.eaio.uuid.UUID;
import com.haedrig.order.domain.Order;
import com.haedrig.order.domain.command.CreateOrderCommand;
import com.haedrig.order.domain.command.LoadOrderCommand;
/**
 * Runner that uses the provided CommandGateway to send some commands to our application.
 *
 * @author Jettro Coenradie
 */
public class CommandGenerator {

    public static void sendCommands(final CommandGateway commandGateway) {
    	
    	final String itemId1 = new UUID().toString();
		commandGateway.send(new CreateOrderCommand(itemId1));
		
    	
//    	StressResult result = StressTestUtils.test(1000, 10000, new StressTask() {
//			
//			public Object doTask() {
////				Order order =  commandGateway.sendAndWait(new LoadOrderCommand(itemId1));
//				//System.out.println(order.getId());
//				try {
//					final String itemId1 = new UUID().toString();
//					commandGateway.sendAndWait(new CreateOrderCommand(itemId1));
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				
//				return null;
//			}
//		});
////    	
//    	System.out.println(StressTestUtils.format(result));
        
        
    }
}
