package com.zoegeop.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
    ApplicationRunner applicationRunner(GreetingRepository greetingRepository){
	    return args -> {
	        greetingRepository.save(new Greeting("hello"));
            greetingRepository.save(new Greeting("hi"));
        };
    }

}

@RestController
class HelloController{
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

@Entity
class Greeting{
    @Id
    @GenerateValue
    private Long id;

    @Column
    private String message;

    public Greeting(){
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Greeting(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId(){
        return id;
    }
}

interface GreetingRepository extends CrudRepository<Greeting,Long>{}