package com.solvedbysunrise.wastedtime;

import com.solvedbysunrise.wastedtime.config.ProductionConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableConfigurationProperties
@EnableAutoConfiguration
public class WastedtimeApplication {


    public static void main(String[] args) {
		SpringApplication.run(
                new Object[] {WastedtimeApplication.class,
                                ProductionConfiguration.class},
                args);
    }


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

//    @Bean
//    public ObjectMapper objectMapper() {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.registerModule(new JodaModule());
//        mapper.registerModules()
//    }
}
