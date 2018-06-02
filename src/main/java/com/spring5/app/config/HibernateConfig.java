package com.spring5.app.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
 
    @Bean
    public LocalSessionFactoryBean getSessionFactory() throws PropertyVetoException {
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();

        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateProperties.put("hibernate.show_sql", "true");
        
        bean.setHibernateProperties(hibernateProperties);
        bean.setDataSource(getDataSource());
        bean.setPackagesToScan("com.spring5.app.dto");
        return bean;
    }
    
    @Bean
    public ComboPooledDataSource getDataSource() throws PropertyVetoException {
    	ComboPooledDataSource dataSource = new ComboPooledDataSource();
    	
    	dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
    	dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/app-db?useSSL=false");
    	dataSource.setUser("root");
    	dataSource.setPassword("qwerty123");
    	dataSource.setAcquireIncrement(10);
    	dataSource.setIdleConnectionTestPeriod(0);
    	dataSource.setInitialPoolSize(5);
    	dataSource.setMaxIdleTime(0);
    	dataSource.setMaxPoolSize(50);
    	dataSource.setMaxStatements(100);
    	dataSource.setMinPoolSize(5);
    	
    	return dataSource;
    }
    
    @Bean
    public JdbcTemplate getJdbcTemplate() throws PropertyVetoException {
    	JdbcTemplate template = new JdbcTemplate();    	
    	template.setDataSource(getDataSource());    	
    	return template;
    }
 
    @Bean
    public HibernateTransactionManager getTransactionManager() throws PropertyVetoException {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
    
}
