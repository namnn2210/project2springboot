package ginp14.project2.springboot.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;


@Controller
public class HomepageController {

    @GetMapping("/")
    public String showHomepage() {
        return "views/homepage";
    }
}
