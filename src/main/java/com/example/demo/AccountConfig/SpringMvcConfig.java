package com.example.demo.AccountConfig;

import com.example.demo.AccountDao.AccountDao;
import com.example.demo.AccountDao.AccountDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.example.demo")
public class SpringMvcConfig  implements WebMvcConfigurer {
    @Bean
    public DataSource getDatasource() {
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/accountdb ");
        dataSource.setUsername("root");
        dataSource.setPassword("araferi123");
        return dataSource;

    }

    @Bean
    public AccountDao getAccountDao()
    {
        return  new AccountDaoImpl(getDatasource());
    }
}
