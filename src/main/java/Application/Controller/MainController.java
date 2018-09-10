package Application.Controller;


import Application.Model.WeatherComponent.WeatherResult;
import Application.Model.WeatherComponent.WeatherStatistic;
import Application.Model.entity.WeatherStat;
import Application.Model.repository.WeatherStatRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;


@Controller
@ComponentScan
@RequestMapping(path="/weather")
public class MainController {


    @Autowired
    private WeatherStatRepository weatherStatRepository;

    //Method to response Local weather
    @GetMapping(path="/getweather")
    public @ResponseBody String getWeather(){
        RestTemplate restTemplate = new RestTemplate();
        String temp = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q=lviv&APPID=4bb9969e1d07e6dd69a8824e9f15f358&units=metric",
                String.class);

        Gson gson = new Gson();
        WeatherResult weatherResult = gson.fromJson(temp, WeatherResult.class);

        WeatherStat weatherStat = new WeatherStat();
        weatherStat.setCityName(weatherResult.getName());
        weatherStat.setDate(weatherResult.getDt());
        weatherStat.setTemperature(weatherResult.getMain());
        weatherStat.setWeather(
                weatherResult.getSys()+
                weatherResult.getWeather()+
                weatherResult.getWind());

        if  (weatherStatRepository.existsByDate(weatherStat.getDate().toString(),weatherStat.getCityName()).toString().matches("1")){
             weatherStatRepository.updateWeather(
                    weatherStat.getTemperature(),
                     weatherStat.getWeather(),
                    weatherStat.getDate().toString(),
                    weatherStat.getCityName());
        }else {
            weatherStatRepository.save(weatherStat);
        }

        return weatherResult.toString();
    }
    //Method to get statistic from all weather which is on DB
    @GetMapping(path = "/stat")
    public @ResponseBody String getStat(){
        WeatherStatistic weatherStatistic = new WeatherStatistic();
        weatherStatistic.setMinTemperature(weatherStatRepository.getMinTempDay());
        weatherStatistic.setMaxTemperature(weatherStatRepository.getMaxTempDay());
        weatherStatistic.setAvarageTemperature(weatherStatRepository.getAvg());
        return new Gson().toJson(weatherStatistic);


    }

//Method for get statistic about a certain period
    @GetMapping(path = "/datepicker")
    public @ResponseBody String getStatFrom(@RequestParam(defaultValue = "0") String startDate, @RequestParam(defaultValue = "0") String endDate){
       if (startDate.equals("0" )&& endDate.equals("0")){
           Calendar calendar = Calendar.getInstance();
           endDate = new java.sql.Date(calendar.getTimeInMillis()).toString();
           calendar.add(Calendar.DAY_OF_MONTH, -7);
           startDate = new java.sql.Date(calendar.getTimeInMillis()).toString();
       }

        WeatherStatistic weatherStatistic = new WeatherStatistic();
        weatherStatistic.setWeatherStatList(weatherStatRepository.getFromPeriod(startDate,endDate));
        weatherStatistic.setMaxTemperature(weatherStatRepository.getMaxTempDayFromPeriod(startDate,endDate));
        weatherStatistic.setMinTemperature(weatherStatRepository.getMinTempDayFromPeriod(startDate,endDate));
        weatherStatistic.setAvarageTemperature(weatherStatRepository.getAvgFromPeriod(startDate,endDate));
        return new Gson().toJson(weatherStatistic);
    }

    // get all data from DB
    @GetMapping(path="/all")
    public @ResponseBody Iterable<WeatherStat> getAllUsers() {
        return weatherStatRepository.findAll();
    }
    //delete all data from DB
    @GetMapping(path = "/deleteall")
    public @ResponseBody String deleteAll(){
        weatherStatRepository.deleteAll();
        return "All delete";
    }
}
