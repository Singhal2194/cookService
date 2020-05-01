//package com.cook.authentication.config;
//
//import static com.cook.authentication.config.ConfigConstants.DATASOURCE_PROPERTIES;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@ConfigurationProperties(locations={DATASOURCE_PROPERTIES})
//@EnableTransactionManagement
//(basePackages=PACKAGE_REPO_INVOICE,
//        entityManagerFactoryRef="invoice_entity_manager_factory",
//        transactionManagerRef="invoice_tx_manager")
//public class CookDBConfig {
//
//    @Value(PROPERTY_INVOICE_PASSWORD)
//    private String password;
//
//    @Bean(name="invoice_ds")
//    @ConfigurationProperties(prefix=PREFIX_DS_INVOICE)
//    @Primary
//    public DataSource invoiceDatasource() {
//        DataSource ds = DataSourceBuilder.create()
//                .password(password)
//                .build();
//        return ds;
//    }
//
//    @Bean(name="invoiceTemplate")
//    public JdbcTemplate invoiceTemplate(){
//        return new JdbcTemplate(invoiceDatasource());
//    }
//
//
//    @Bean(name="invoice_entity_manager_factory")
//    public LocalContainerEntityManagerFactoryBean bapiEMF(EntityManagerFactoryBuilder builder) {
//        LocalContainerEntityManagerFactoryBean factory = builder
//                .dataSource(invoiceDatasource())
//                .packages(PACKAGE_DOMAIN_INVOICE)
//                .persistenceUnit(PERSISTENCE_UNIT_INVOICE)
//                .build();
//        return factory;
//    }
//
//    @Bean(name="invoice_tx_manager")
//    public PlatformTransactionManager bapiTransactionManager(@Qualifier("invoice_entity_manager_factory") EntityManagerFactory emf){
//        JpaTransactionManager txManager = new JpaTransactionManager(emf);
//        return txManager;
//    }
//
//    @Bean
//    public HibernateExceptionTranslator exceptionTranslator(){
//        return new HibernateExceptionTranslator();
//    }
//
//}
//
