package dev.euchigere.eventsmanager.controllers;

import dev.euchigere.eventsmanager.dto.ServiceResponse;
import dev.euchigere.eventsmanager.dto.UserDTO;
import dev.euchigere.eventsmanager.models.User;
import dev.euchigere.eventsmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/auth/")
public class LoginAndSignUpController {
    @Autowired
    UserService userService;

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("signup")
    public String signUp(User user) {
        return "signup";
    }

    @PostMapping("login")
    public String login(@RequestParam(value = "login-email") String email,
                        @RequestParam(value = "login-password") String password,
                        RedirectAttributes redirectAttr,
                        HttpSession session) {
        ServiceResponse<UserDTO> response = userService.authenticateUser(email, password);
        if (!response.isStatus()) {
            redirectAttr.addFlashAttribute("errorMessage", response.getMessage());
            return "redirect:/auth/login";
        }
        session.setAttribute("currentUser", response.getData());
        return "redirect:/";
    }

    @PostMapping("signup")
    public String signUp(@Valid User user, BindingResult result, RedirectAttributes redirectAttr) {
        if (result.hasErrors()) {
            redirectAttr.addFlashAttribute("user", user);
            return "redirect:/auth/signup";
        }

        ServiceResponse<User> response = userService.validateUser(user);
        if (!response.isStatus()) {
            redirectAttr.addFlashAttribute("errorMessage", response.getMessage());
            return "redirect:/auth/signup";
        }
        redirectAttr.addFlashAttribute("flashMessage", response.getMessage());
        return "redirect:/auth/login";
    }
}
