package by.hoitan.demo2.controller;

import by.hoitan.demo2.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    @Autowired
    private EmailService emailService;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring";
    }

    @PostMapping(path = "/send-email")
    public String sendEmail(@RequestParam(name = "to") String email) {

        emailService.sendEmail(email);

        return "OK";
    }

}
