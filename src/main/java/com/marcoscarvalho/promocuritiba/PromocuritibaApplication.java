package com.marcoscarvalho.promocuritiba;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
@EnableCaching
public class PromocuritibaApplication {

	@Autowired
	private Logger logger;

	public static void main(String[] args) {
		SpringApplication.run(PromocuritibaApplication.class, args);
	}

	@Value("${dburl}")
	public String url;

	@Value("${dbuser}")
	public String username;

	@Value("${dbpass}")
	public String password;

	@Bean
	public DataSource dataSource() {
		logger.info("[url=" + url + ", username=" + username + ", password=" + password + "]");
		DataSource dataSource = DataSourceBuilder.create().driverClassName("org.postgresql.Driver").url(url)
				.username(username).password(password).build();
		return dataSource;
	}

	@Bean
	@Scope("prototype")
	public Logger produceLogger(InjectionPoint injectionPoint) {
		Class<?> classOnWired = injectionPoint.getMember().getDeclaringClass();
		return LoggerFactory.getLogger(classOnWired);
	}

}
