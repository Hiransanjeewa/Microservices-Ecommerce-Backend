package com.example.RegisterService.config;

import com.example.RegisterService.client.LoginServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;


    @Configuration
    public class WebClientConfig {
        @Autowired
        private LoadBalancedExchangeFilterFunction filterFunction;


        @Bean
        public WebClient loginWebClient() {
            return WebClient.builder()
                    .baseUrl("http://login-service")
                    .filter(filterFunction)
                    .build();
        }

        @Bean
        public LoginServiceClient loginServiceClient() {
            HttpServiceProxyFactory httpServiceProxyFactory
                    = HttpServiceProxyFactory
                    .builder(WebClientAdapter.forClient(loginWebClient()))
                    .build();
            return httpServiceProxyFactory.createClient(LoginServiceClient.class);
        }

    }


