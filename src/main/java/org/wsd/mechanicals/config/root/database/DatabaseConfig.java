package org.wsd.mechanicals.config.root.database;

import javax.sql.DataSource;

import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

public interface DatabaseConfig {

	public LocalContainerEntityManagerFactoryBean entityManagerFactory();

	public DataSource dataSource();

}