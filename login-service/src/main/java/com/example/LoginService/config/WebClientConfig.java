package com.example.LoginService.config;


import com.example.LoginService.client.RegisterServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;



    @Configuration
    public class WebClientConfig {

        @Autowired
        private LoadBalancedExchangeFilterFunction filterFunction;


        @Bean
        public WebClient registerWebClient() {
            return WebClient.builder()
                    .baseUrl("http://register-service")
                    .filter(filterFunction)
                    .build();
        }

        @Bean
        public RegisterServiceClient registerClient() {
            HttpServiceProxyFactory httpServiceProxyFactory
                    = HttpServiceProxyFactory
                    .builder(WebClientAdapter.forClient(registerWebClient()))
                    .build();
            return httpServiceProxyFactory.createClient(RegisterServiceClient.class);
        }
    }