package com.example.springmongo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
public class MongoDbConnectionConfig extends AbstractMongoConfiguration {

	@Override
	protected String getMappingBasePackage() {
		return "com.example.springmongo";
	}

	@Override
	public MongoClient mongoClient() {
		/*- This is a Driver URI from my cluster created at
		 *  https://cloud.mongodb.com/
		 */
		MongoClientURI uri = new MongoClientURI(
				"mongodb+srv://lavkherwa:password416@mymongodb-njb04.mongodb.net/test?retryWrites=true&w=majority");

		return new MongoClient(uri);
	}

	@Override
	protected String getDatabaseName() {
		return "test";
	}

}
