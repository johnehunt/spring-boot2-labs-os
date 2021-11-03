package com.jjh.bookstore.config;

import com.jjh.bookstore.jms.Sender;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
@PropertySource("classpath:application.properties")
public class SenderConfig {

    @Value("${artemis.broker-url}")
    private String brokerUrl;


    @Bean
    public JmsTemplate jmsTemplate() {
        ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory(brokerUrl);
        CachingConnectionFactory ccf = new CachingConnectionFactory(cf);
        return new JmsTemplate(ccf);
    }

    @Bean
    public Sender sender() {
        return new Sender();
    }

}

