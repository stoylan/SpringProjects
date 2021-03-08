package com.springframework.springdi.config;

import com.springframework.springdi.examplebeans.FakeDataSources;
import com.springframework.springdi.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jms.properties")
})
public class PropertyConfig {

    @Value("${com.username}")
    String user;

    @Value("${com.password}")
    String password;

    @Value("${com.dburl}")
    String url;

    @Value("${com.jms.username}")
    String JMSuser;

    @Value("${com.jms.password}")
    String JMSpassword;

    @Value("${com.jms.dburl}")
    String JMSurl;

    @Bean
    public FakeJmsBroker fakeJmsBroker(){
        FakeJmsBroker fakeJmsBroker =new FakeJmsBroker();
        fakeJmsBroker.setUsername(JMSuser);
        fakeJmsBroker.setPassword(JMSpassword);
        fakeJmsBroker.setUrl(JMSurl);
        return fakeJmsBroker;

    }

    @Bean
    public FakeDataSources fakeDataSources(){
        FakeDataSources fakeDataSources = new FakeDataSources();
        fakeDataSources.setUser(user);
        fakeDataSources.setPassword(password);
        fakeDataSources.setUrl(url);
        return fakeDataSources;

    }


}
