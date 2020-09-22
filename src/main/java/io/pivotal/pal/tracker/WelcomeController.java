package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @Value("${welcome.message}")
    private String WELCOME_MESSAGE;

    WelcomeController(){

    }

   public WelcomeController(java.lang.String message)
    {
        WELCOME_MESSAGE=message;
    }
    @GetMapping("/")
    public String sayHello() {
        return WELCOME_MESSAGE;
    }
}