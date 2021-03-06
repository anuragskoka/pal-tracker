package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    private String WELCOME_MESSAGE;

//    WelcomeController(){
//
//    }

   public WelcomeController(@Value("${welcome.message}")java.lang.String message)
    {
        WELCOME_MESSAGE=message;
    }
    @GetMapping("/")
    public String sayHello() {
        return WELCOME_MESSAGE;
    }
}