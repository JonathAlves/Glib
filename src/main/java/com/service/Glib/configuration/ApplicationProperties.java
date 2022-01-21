package com.service.Glib.configuration;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class ApplicationProperties {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
