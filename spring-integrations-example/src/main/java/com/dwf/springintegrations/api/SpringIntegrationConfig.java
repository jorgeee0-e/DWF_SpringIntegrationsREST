package com.dwf.springintegrations.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;

import java.io.File;

@Configuration
@EnableIntegration
public class SpringIntegrationConfig {

    /*@Bean
    @InboundChannelAdapter(value = "fileInputChannel", poller  = @Poller(fixedDelay = "1000"))
        public FileReadingMessageSource fileReadingMessageSource() {
        FileReadingMessageSource reader = new FileReadingMessageSource();
        reader.setDirectory(new File("C:\\Users\\Administrador\\Desktop\\Source"));
        return reader;
    }

    @Bean
    @ServiceActivator(inputChannel = "fileInputChannel")
    public FileWritingMessageHandler fileWritingMessageHandler() {
        FileWritingMessageHandler writter = new FileWritingMessageHandler(new File("C:\\Users\\Administrador\\Desktop\\Destination"));
        writter.setAutoCreateDirectory(true);
        writter.setExpectReply(false);
        return writter;
    }*/
}
