package com.keepgoing.apm;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(basePackages="com.keepgoing.apm")
@EnableTransactionManagement 
public class DatabaseConfig {
 
	 @Value("${spring.datasource.url}")
	 private String url;
	 @Value("${spring.datasource.driver-class-name}")
	 private String driverClassName;
	 @Value("${spring.datasource.username}")
	 private String username;
	 @Value("${spring.datasource.password}")
	 private String password;


	 @Bean
    public DataSource customDataSource() {
        return DataSourceBuilder.create()
                                .url(url)
                                .driverClassName(driverClassName)
                                .username(username)
                                .password(password)
                                .build();
    }
	    
    @Bean
    public  SqlSessionFactory sqlSessionFactory(DataSource dataSource)throws Exception {
        final SqlSessionFactoryBean sessionFactory =new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver =new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        return sessionFactory.getObject();
    }
    
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory)throws Exception {
      final SqlSessionTemplate sqlSessionTemplate =new SqlSessionTemplate(sqlSessionFactory);
      return sqlSessionTemplate;
    }
 
}

