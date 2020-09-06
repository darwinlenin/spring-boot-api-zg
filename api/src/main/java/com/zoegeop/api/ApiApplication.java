package com.zoegeop.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApiApplication {
    private final GreetingRepository greetingRepository;
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

	@GetMapping("/")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/greetings")
    public List<Greeting> greeting(){
	    return greetingRepository.findAll();
    }

    ApiApplication(GreetingRepository greetingRepository){
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

    public void setId(Long id) {
        this.id = id;
    }

    public Greeting(){

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