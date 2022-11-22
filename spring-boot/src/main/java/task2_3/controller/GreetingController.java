package task2_3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import task2_3.Greeting;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";


    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        return new Greeting(10,
                String.format(template, name));
    }
}
