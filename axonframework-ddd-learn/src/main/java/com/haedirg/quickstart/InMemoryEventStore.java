package com.haedirg.quickstart;

import static java.util.Collections.singletonList;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.axonframework.domain.DomainEventMessage;
import org.axonframework.domain.DomainEventStream;
import org.axonframework.domain.SimpleDomainEventStream;
import org.axonframework.eventstore.EventStore;


public class InMemoryEventStore implements EventStore {
	
	private static final int COMMAND_COUNT = 50 * 1000 * 1000;
	
	private final Map<String, DomainEventMessage> storedEvents = new HashMap<String, DomainEventMessage>();
    private final CountDownLatch countDownLatch = new CountDownLatch((int) (COMMAND_COUNT + 1L));

	public void appendEvents(String type, DomainEventStream events) {
		 if (events == null || !events.hasNext()) {
	            return;
	        }
	        String key = (String) events.next().getAggregateIdentifier();
	        DomainEventMessage<?> lastEvent = null;
	        
	        while(events.hasNext()){
	         countDownLatch.countDown();
	         lastEvent = (DomainEventMessage<?>) events.next();
	        }
	        storedEvents.put(key, lastEvent);
	}

	public DomainEventStream readEvents(String type, Object identifier) {
		return new SimpleDomainEventStream(singletonList(storedEvents.get(identifier)));
	}

}
