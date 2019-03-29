package ginp14.project2.springboot.controller;


import ginp14.project2.springboot.entity.User;
import ginp14.project2.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


@Controller
public class HomepageController {

    @RequestMapping("/")
    public String showHomepage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String result = auth.getName();
        User user = userService.findByUsername(result);
        model.addAttribute("user",user);
        return "views/homepage";
    }

    @Autowired
    private UserService userService;


    @GetMapping("/profile")
    public String showUserInfo(Model model, Principal principal) {
        String result = principal.getName();
        User user = userService.findByUsername(result);
        model.addAttribute("user",user);
        return "views/users/user_info";
    }
}
