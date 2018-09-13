package Application.controller;


import Application.model.WeatherComponent.WeatherResult;
import Application.model.WeatherComponent.WeatherStatistic;
import Application.model.entity.WeatherStat;
import Application.repository.WeatherStatRepository;
import Application.service.impl.WeatherStatServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Calendar;


@Controller
@ComponentScan
@RequestMapping(path="/weather")
public class MainController {


    @Autowired
    private WeatherStatServiceImpl weatherStatService;
    //Method to response Local weather
    @GetMapping(path="/getweather")
    public @ResponseBody String getWeather(){
        return new Gson().toJson(weatherStatService.getWeather());
    }
    //Method to get statistic from all weather which is on DB
    @GetMapping(path = "/stat" )
    public @ResponseBody String getStat(){
        return new Gson().toJson(weatherStatService.getStatistic());
    }

//Method for get statistic about a certain period
    @GetMapping(path = "/datepicker")
    public @ResponseBody String getStatFrom(@RequestParam(defaultValue = "0") String startDate, @RequestParam(defaultValue = "0") String endDate){
     return new Gson().toJson(weatherStatService.getStatisticFrom(startDate,endDate));
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
