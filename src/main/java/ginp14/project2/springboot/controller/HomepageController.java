package ginp14.project2.springboot.controller;


import ginp14.project2.springboot.entity.User;
import ginp14.project2.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;


@Controller
public class HomepageController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showHomepage() {
        return "views/homepage";
    }


    @GetMapping("/profile")
    public String showUserInfo(Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        model.addAttribute("user",user);
        return "views/users/user_info";
    }
}
