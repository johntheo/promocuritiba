package com.marcoscarvalho.promocuritiba;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:env/db.properties")
public class DBConfig {
	
	@Autowired
	private Logger logger;
	
	@Value("${dburl}")
	public String url;

	@Value("${dbuser}")
	public String username;

	@Value("${dbpass}")
	public String password;

	@Bean
	public DataSource dataSource() {
		logger.info("dbConfig [url=" + url + ", username=" + username + ", password=" + password + "]");
		DataSource dataSource = DataSourceBuilder.create().driverClassName("org.postgresql.Driver").url(url)
				.username(username).password(password).build();
		return dataSource;
	}

}
