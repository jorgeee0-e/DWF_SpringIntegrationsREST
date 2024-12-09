package com.dwf.springintegrations.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.StandardIntegrationFlow;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

@Configuration
public class IntegrationConfig {
    @Bean
    @Primary
    public MessageChannel inputChannel(){
        return new DirectChannel();
    }

    @Bean
    public StandardIntegrationFlow standardFlow(){
        return IntegrationFlow.from(inputChannel())
                .handle(logginHandler())
                .get();
    }

    @Bean
    @ServiceActivator(inputChannel = "inputChannel")
    public MessageHandler logginHandler(){
        LoggingHandler loggingHandler = new LoggingHandler("INFO");
        loggingHandler.setLogExpressionString("'Mensaje procesado: ' + payload");
        return loggingHandler;
    }
}
