package ginp14.project2.springboot.controller;




import ginp14.project2.springboot.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomepageController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/")
    public String showHomepage(Model model) {
        model.addAttribute("movies",movieService.findAll());
        return "views/homepage";
    }

}
