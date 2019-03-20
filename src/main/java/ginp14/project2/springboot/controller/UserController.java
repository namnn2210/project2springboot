package ginp14.project2.springboot.controller;

import ginp14.project2.springboot.entity.User;
import ginp14.project2.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String showSignup(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "views/signup_form";
    }

    @PostMapping("/signup")
    public String processSignup(@Valid @ModelAttribute("user")User user, Model model, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "views/signup_form";
        }
        if(userService.isUserPresent(user.getUsername())) {
            model.addAttribute("exist",true);
            return "views/signup_form";
        }
            userService.save(user);
        return "views/registration-confirmation";
    }
}
