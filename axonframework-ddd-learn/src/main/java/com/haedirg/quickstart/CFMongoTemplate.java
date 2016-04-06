package com.haedirg.quickstart;


import com.mongodb.DB;
import com.mongodb.DBCollection;
import org.axonframework.eventstore.mongo.MongoTemplate;
import org.springframework.data.mongodb.MongoDbFactory;

public class CFMongoTemplate implements MongoTemplate {

    private static final String DEFAULT_DOMAINEVENTS_COLLECTION = "domainevents";
    private static final String DEFAULT_SNAPSHOTEVENTS_COLLECTION = "snapshotevents";

    private MongoDbFactory mongoDbFactory;

    public CFMongoTemplate(MongoDbFactory mongoDbFactory) {
        this.mongoDbFactory = mongoDbFactory;
    }

    @Override
    public DBCollection domainEventCollection() {
    	return database().getCollection(DEFAULT_DOMAINEVENTS_COLLECTION);
    }

    @Override
    public DBCollection snapshotEventCollection() {
    	return database().getCollection(DEFAULT_SNAPSHOTEVENTS_COLLECTION);
    }

    public DB database() {
    	return mongoDbFactory.getDb();
    }
}
