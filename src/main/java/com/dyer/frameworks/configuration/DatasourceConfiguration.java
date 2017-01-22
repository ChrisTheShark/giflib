package com.dyer.frameworks.configuration;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;

/**
 * Datasource specific configuration <code>class</code>.
 */
@Configuration
@PropertySource("application.properties")
public class DatasourceConfiguration {

    @Autowired
    Environment environment;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        Resource configuration = new ClassPathResource("hibernate.cfg.xml");
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        sessionFactory.setConfigLocation(configuration);
        sessionFactory.setPackagesToScan(
                environment.getProperty("giflib.entity.package"));
        sessionFactory.setDataSource(datasource());

        return sessionFactory;
    }

    @Bean
    public BasicDataSource datasource() {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(environment.getProperty("giflib.db.driver"));
        dataSource.setUrl(environment.getProperty("giflib.db.url"));
        dataSource.setUsername(environment.getProperty("giflib.db.username"));
        dataSource.setPassword(environment.getProperty("giflib.db.password"));

        return dataSource;
    }

}
