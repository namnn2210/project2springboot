package ginp14.project2.springboot.controller;


import ginp14.project2.springboot.entity.User;
import ginp14.project2.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;


@Controller
@CrossOrigin(origins = "http://localhost:8080")
public class HomepageController {

    @RequestMapping("/")
    public String showHomepage() {
        return "views/homepage";
    }

    @Autowired
    private UserService userService;


    @GetMapping("/profile")
    public String showUserInfo(Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        model.addAttribute("user",user);
        return "views/users/user_info";
    }
}
