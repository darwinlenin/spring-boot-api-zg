package com.zoegeop.api;

import com.zoegeop.api.GreetingRepository;
import com.zoegeop.api.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController{
    private final GreetingRepository greetingRepository;

    @GetMapping("/")
    String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/greetings")
    Iterable<Greeting> greetings(){
        return greetingRepository.findAll();
    }

    HelloController(GreetingRepository greetingRepository){
        this.greetingRepository = greetingRepository;
    }
}