package com.nj.samples.tracing.serviceC.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.sleuth.SpanName;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/servicec")
@SpanName("ServiceCRestCall")
@RestController
public class ServiceCRestController {
    @GetMapping("/b")
    public String startServiceA()
    {
        log.info("Entered the Rest Controller on Service C ");
        return " Hello From Service C";
    }
}
