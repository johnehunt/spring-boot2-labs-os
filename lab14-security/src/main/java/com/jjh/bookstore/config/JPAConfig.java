package com.jjh.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.jjh.bookstore.repository"})
@EnableJpaRepositories("com.jjh.bookstore.repository")
public class JPAConfig {

    // Name of bean must be entityManagerFactory for Repos to work
    @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManager(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setPersistenceUnitName("BookstoreJPA");
        factory.setJpaDialect(new HibernateJpaDialect());
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
        factory.setJpaVendorAdapter(adapter);
        factory.setPackagesToScan("com.jjh.bookstore.domain");
        return factory;
    }

}
