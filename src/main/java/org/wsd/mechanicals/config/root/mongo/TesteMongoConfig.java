package org.wsd.mechanicals.config.root.mongo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.wsd.mechanicals.config.root.annotation.Teste;

import com.mongodb.Mongo;

@Teste
@Configuration
public class TesteMongoConfig implements MongoConfig {

	@Bean
	public Mongo mongo() throws Exception {
		return new Mongo("127.0.0.1");
	}

	@Override
	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(mongo(), "mechanicals");
	}

	@Override
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongoDbFactory());
	}

}