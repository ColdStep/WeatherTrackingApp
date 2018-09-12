package Application.service.impl;

import Application.model.WeatherComponent.WeatherResult;
import Application.model.WeatherComponent.WeatherStatistic;
import Application.model.entity.WeatherStat;
import Application.repository.WeatherStatRepository;
import Application.service.WeatherStatService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;

@Service
public class WeatherStatServiceImpl implements WeatherStatService {

    @Autowired
    private WeatherStatRepository weatherStatRepository;

    @Override
    public WeatherResult getWeather() {
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
        return weatherResult;
    }

    @Override
    public WeatherStatistic getStatistic() {
        WeatherStatistic weatherStatistic = new WeatherStatistic();
        weatherStatistic.setMinTemperature(weatherStatRepository.getMinTempDay());
        weatherStatistic.setMaxTemperature(weatherStatRepository.getMaxTempDay());
        weatherStatistic.setAvarageTemperature(weatherStatRepository.getAvg());
        return  weatherStatistic ;
    }

    @Override
    public WeatherStatistic getStatisticFrom(String startDate, String endDate) {
        if (startDate.equals("0" )&& endDate.equals("0")){
            Calendar calendar = Calendar.getInstance();
            endDate = new java.sql.Date(calendar.getTimeInMillis()).toString();
            calendar.add(Calendar.DAY_OF_MONTH, -7);
            startDate = new java.sql.Date(calendar.getTimeInMillis()).toString();
        }

        WeatherStatistic weatherStatistic = new WeatherStatistic() ;
        weatherStatistic.setWeatherStatList(weatherStatRepository.getFromPeriod(startDate,endDate));
        weatherStatistic.setMaxTemperature(weatherStatRepository.getMaxTempDayFromPeriod(startDate,endDate));
        weatherStatistic.setMinTemperature(weatherStatRepository.getMinTempDayFromPeriod(startDate,endDate));
        weatherStatistic.setAvarageTemperature(weatherStatRepository.getAvgFromPeriod(startDate,endDate));

        return weatherStatistic;
    }

    @Override
    public Iterable<WeatherStat> getAll() {
        return weatherStatRepository.findAll();
    }

    @Override
    public String deleteAll() {
        weatherStatRepository.deleteAll();
        return "All delete";
    }
}
