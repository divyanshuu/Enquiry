package com.proptiger.server;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;





@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "serverEntityManagerFactory",
		transactionManagerRef = "serverTransactionManager",
		basePackages = { "com.proptiger.server.repo" }
		)
public class ServerConfig {

	@Primary
	@Bean(name = "serverDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.server")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "serverEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("serverDataSource") DataSource dataSource) {
		return builder
				.dataSource(dataSource)
				.packages("com.proptiger.server.entity")
				.persistenceUnit("server")
				.build();
	}

	@Primary
	@Bean(name = "serverTransactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("serverEntityManagerFactory") EntityManagerFactory 
			entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
