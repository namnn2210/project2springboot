package ginp14.project2.springboot.controller;

import ginp14.project2.springboot.entity.Category;
import ginp14.project2.springboot.entity.Movie;
import ginp14.project2.springboot.service.CategoryService;
import ginp14.project2.springboot.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/home")
    public String showAdminDashboard() {
        return "views/admin/dashboard";
    }

    @GetMapping("/movie")
    public String showAdminMovie(Model model){
        List<Movie> movieList = movieService.findAll();
        List<Category> categoryList = categoryService.findAll();
        int a = categoryList.size();
        model.addAttribute("movieList",movieList);
        model.addAttribute("categoryList", categoryList);
        return "views/admin/movie/list_movie";
    }

    @GetMapping("/movie/create")
    public String showAdminMovieCreateForm(Model model){
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "views/admin/movie/create_movie";
    }

    @GetMapping("/category")
    public String showAdminCategory(Model model){
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "views/admin/category/list_category";
    }
}
