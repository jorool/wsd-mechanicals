package org.wsd.mechanicals.config.root.mongo;

import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

public interface MongoConfig {

	public MongoDbFactory mongoDbFactory() throws Exception;

	public MongoTemplate mongoTemplate() throws Exception;

}