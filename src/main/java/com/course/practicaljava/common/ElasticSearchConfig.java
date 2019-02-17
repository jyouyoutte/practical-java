package com.course.practicaljava.common;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.Resource;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@PropertySource(value = "classpath:elasticsearch.properties")
@EnableElasticsearchRepositories(basePackages = {"com.course.practicaljava.repository"})
public class ElasticSearchConfig {

	private static final Logger log = LoggerFactory.getLogger(ElasticSearchConfig.class);

	@Resource
	private Environment environment;

	@Bean
	public Client client() throws UnknownHostException {

		log.info("Loading ES properties files");


		String host = environment.getProperty("elasticsearch.host");
		int port = Integer.parseInt(environment.getProperty("elasticsearch.port"));
		
		log.info("host : " +  host);
		log.info("Port : " +  port);

		var transportClient = new PreBuiltTransportClient(Settings.EMPTY);
		transportClient.addTransportAddress(new TransportAddress(InetAddress.getByName(host), port));

		return transportClient;
	}

	@Bean
	public ElasticsearchOperations esTemplate() throws UnknownHostException {
		return new ElasticsearchTemplate(client());
	}
}
