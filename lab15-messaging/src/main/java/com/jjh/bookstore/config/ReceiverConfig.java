package com.jjh.bookstore.config;

import com.jjh.bookstore.jms.Receiver;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

@Configuration
@EnableJms
@PropertySource("classpath:application.properties")
public class ReceiverConfig {

    @Value("${artemis.broker-url}")
    private String brokerUrl;

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory(brokerUrl);
        factory.setConnectionFactory(cf);
        factory.setConcurrency("3-10");
        return factory;
    }

    @Bean
    public Receiver receiver() {
        return new Receiver();
    }

}

