package com.solvedbysunrise.wastedtime.controller;

import com.solvedbysunrise.wastedtime.data.dto.Hello;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping(method = GET)
    public Hello sayHello() {
        final Hello helloWorld = new Hello();
        helloWorld.setWho("harry");
        return helloWorld;
    }
}
