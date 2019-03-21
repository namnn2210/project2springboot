package ginp14.project2.springboot.controller;

import ginp14.project2.springboot.entity.User;
import ginp14.project2.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Go to register + login form
    @GetMapping("/register")
    public String showSignup(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "views/register";
    }

    // Registration process
    @PostMapping("/registerProcess")
    public String processSignup(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "views/register";
        }
        if (userService.isUserPresent(user.getUsername()) || userService.isEmailPresent(user.getEmail())) {
            model.addAttribute("exist", true);
            return "views/register";
        }
        userService.save(user);
        return "views/registration-confirmation";
    }

}