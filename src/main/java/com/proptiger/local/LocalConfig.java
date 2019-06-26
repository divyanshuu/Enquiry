package com.proptiger.local;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "localEntityManagerFactory",
		transactionManagerRef = "localTransactionManager",
		basePackages = { "com.proptiger.local.repo" }
		)
public class LocalConfig {
	@Bean(name = "localDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.local")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "localEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean localEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("localDataSource") DataSource dataSource
			) {
		return
				builder
				.dataSource(dataSource)
				.packages("com.proptiger.local.entity")
				.persistenceUnit("local")
				.build();
	}
	@Bean(name = "localTransactionManager")
	public PlatformTransactionManager localTransactionManager(@Qualifier("localEntityManagerFactory") EntityManagerFactory
			localEntityManagerFactory) {
		return new JpaTransactionManager(localEntityManagerFactory);
	}


}
