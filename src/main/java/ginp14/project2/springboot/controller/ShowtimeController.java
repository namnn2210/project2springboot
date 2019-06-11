package ginp14.project2.springboot.controller;


import ginp14.project2.springboot.entity.FindCriteria;
import ginp14.project2.springboot.entity.ShowTime;
import ginp14.project2.springboot.service.ShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/showtime")
public class ShowtimeController {

    @Autowired
    private ShowTimeService showTimeService;

    @PostMapping("/getShowtimes")
    public @ResponseBody List<ShowTime> getShowtimes(@RequestBody FindCriteria find_data) {
        String newDateAarr[] = find_data.getDate().split("/");
        StringBuilder sb = new StringBuilder();
        sb.append(newDateAarr[2]).append("-").append(newDateAarr[0]).append("-").append(newDateAarr[1]);
        return showTimeService.findByDateAndMovieId(sb.toString(),find_data.getId());
    }
}
