package dev.euchigere.eventsmanager.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth/")
public class LoginAndSignUpController {
    @GetMapping("login")
    public String login() {
        return "login";
    }
}
