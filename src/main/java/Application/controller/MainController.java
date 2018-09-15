package Application.controller;


import Application.model.entity.WeatherStat;
import Application.service.impl.WeatherStatServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ComponentScan
@RequestMapping(path="/weather")
public class MainController {


    @Autowired
    private WeatherStatServiceImpl weatherStatService;

    //Method to response Local weather

    @GetMapping(path="/getweather")
    public @ResponseBody String getWeather() throws Exception{
        return new ObjectMapper().writeValueAsString(weatherStatService.getWeather());
    }
    //Method to get statistic from all weather which is on DB

    @GetMapping(path = "/stat" )
    public @ResponseBody String getStat() throws Exception{
        return new ObjectMapper().writeValueAsString(weatherStatService.getStatistic());
    }

    //Method for get statistic about a certain period

    @GetMapping(path = "/datepicker")
    public @ResponseBody String getStatFrom(@RequestParam(defaultValue = "0") String startDate, @RequestParam(defaultValue = "0") String endDate) throws Exception{
     return new ObjectMapper().writeValueAsString(weatherStatService.getStatisticFrom(startDate,endDate));
    }

    // get all data from DB

    @GetMapping(path="/all")
    public @ResponseBody Iterable<WeatherStat> getAllUsers() {
        return weatherStatService.getAll();
    }

    //delete all data from DB

    @GetMapping(path = "/deleteall")
    public @ResponseBody String deleteAll(){
        return weatherStatService.deleteAll();
    }
}
