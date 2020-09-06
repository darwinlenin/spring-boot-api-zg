package com.zoegeop.api;

import org.springboot.model.Greeting;
import org.springframework.data.repository.CrudRepository;

public interface GreetingRepository extends CrudRepository<Greeting, Long> {

    List<Greeting> findByText(String text);
}