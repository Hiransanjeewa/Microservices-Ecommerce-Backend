package com.example.LoginService.config;

import com.example.LoginService.client.TestingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig2 {
    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;


    @Bean
    public WebClient testingWebClient() {
        return WebClient.builder()
                .baseUrl("http://register-service")
                .filter(filterFunction)
                .build();
    }

    @Bean
    public TestingClient testingClient() {
        HttpServiceProxyFactory httpServiceProxyFactory
                = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(testingWebClient()))
                .build();
        return httpServiceProxyFactory.createClient(TestingClient.class);
    }

}
