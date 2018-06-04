package br.com.cmabreu.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

// https://howtodoinjava.com/spring5/webmvc/spring5-mvc-hibernate5-example/

@Configuration
@EnableTransactionManagement
public class HibernateConfig {

    //@Autowired
    //private ApplicationContext context;

    //@Autowired
    //private Environment env;    

	@Autowired
	private ComboPooledDataSource dataSource;	
	
	public void setDataSource(ComboPooledDataSource dataSource) {
		this.dataSource = dataSource;
	}	
	
	
    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
    	System.out.println("HibernateConfig :: getSessionFactory");
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource( dataSource );
        factoryBean.setHibernateProperties( hibernateProperties() );
        factoryBean.setPackagesToScan("br.com.cmabreu.model");
        System.out.println("Hibernate Configurado.");
        return factoryBean;
    }

 
    
    
    @Bean
    public HibernateTransactionManager getTransactionManager() {
    	System.out.println("HibernateConfig :: getTransactionManager");
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory( getSessionFactory().getObject() );
        return transactionManager;
    }
    
    private Properties hibernateProperties() {
        Properties pp = new Properties();
        
        pp.setProperty( "hibernate.hbm2ddl.auto", "update" );
        pp.setProperty( "hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect" );
        pp.setProperty( "hibernate.connection.driver_class", "org.postgresql.Driver" );
        pp.setProperty( "hibernate.hbm2ddl.auto", "update" );
        pp.setProperty( "hibernate.id.new_generator_mappings", "true" );
        
   
        
        /*
    	
    	//pp.setProperty( "hibernate.globally_quoted_identifiers", "org.postgresql.Driver" );
    	//pp.setProperty( "hibernate.connection.provider_class", "org.hibernate.connection.C3P0ConnectionProvider" );
    	pp.setProperty( "hibernate.connection.provider_class", "org.hibernate.service.jdbc.connections.internal.C3P0ConnectionProvider" );
    	pp.setProperty( "hibernate.c3p0.autoCommitOnClose", "true" );
    	pp.setProperty( "hibernate.c3p0.min_size","5");
    	pp.setProperty( "hibernate.c3p0.max_size","100");
    	pp.setProperty( "hibernate.c3p0.timeout","10");
    	pp.setProperty( "hibernate.c3p0.max_statements","50");
    	pp.setProperty( "hibernate.c3p0.idle_test_period","3000");
    	pp.setProperty( "hibernate.c3p0.validate","true");    	
    	*/
    	return pp;
     }    
    
	
}
