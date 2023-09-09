package by.hoitan.demo2.controller;

import by.hoitan.demo2.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class HelloController {

    private EmailService emailService;

    @Autowired
    public HelloController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("title", "send email");
        return "hello";
    }

    @PostMapping(path = "/send-email")
    public String sendEmail(Model model, @RequestParam String titele, @RequestParam String theam) {

        emailService.sendEmail(titele, theam);

        return "redirect:/hello";
    }

}
