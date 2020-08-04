package com.nj.samples.tracing.serviceB.client.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ServiceCRestClient {
    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Value("${servicec.resturi}")
    String resourceUri;

    public String fetchFromServiceC()
    {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String> response
                = restTemplate.getForEntity(resourceUri, String.class);
        return response.toString();
    }
}
