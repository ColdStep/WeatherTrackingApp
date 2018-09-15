package Application.service.impl;

import Application.dto.WeatherStatisticDto;
import Application.model.WeatherComponent.WeatherResult;
import Application.model.entity.WeatherStat;
import Application.repository.WeatherStatRepository;
import Application.service.WeatherStatService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

@Service
public class WeatherStatServiceImpl implements WeatherStatService {

    @Autowired
    private WeatherStatRepository weatherStatRepository;

    @Override
    public WeatherResult getWeather()  {
        RestTemplate restTemplate = new RestTemplate();
        String temp = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q=lviv&APPID=4bb9969e1d07e6dd69a8824e9f15f358&units=metric",
                String.class);

        WeatherResult weatherResult = null;
        try {
            weatherResult = new ObjectMapper().readValue(temp, WeatherResult.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        WeatherStat weatherStat = new WeatherStat();
        weatherStat.setCityName(weatherResult.getName());
        weatherStat.setCountry(weatherResult.getSys().getCountry());
        weatherStat.setDate(new java.sql.Date(new Date(weatherResult.getDt()*1000).getTime()));
        weatherStat.setTemperature(weatherResult.getMain().getTemp());
        weatherStat.setHumidity(weatherResult.getMain().getHumidity());
        weatherStat.setPressure(weatherResult.getMain().getPressure());
        weatherStat.setWeather(weatherResult.getWeather().toString());
        weatherStat.setCoord(weatherResult.getCoord().toString());
        weatherStat.setWind(weatherResult.getWind().toString());
        weatherStat.setCityCod(weatherResult.getCod());
        weatherStat.setSunrise(new java.sql.Date(new Date(weatherResult.getSys().getSunrise()*1000).getTime()));
        weatherStat.setSenset(new java.sql.Date(new Date(weatherResult.getSys().getSunset()*1000).getTime()));

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
    public WeatherStatisticDto getStatistic() {
        WeatherStatisticDto weatherStatisticDto = new WeatherStatisticDto();
        weatherStatisticDto.setMinTemperature(weatherStatRepository.getMinTempDay());
        weatherStatisticDto.setMaxTemperature(weatherStatRepository.getMaxTempDay());
        weatherStatisticDto.setAvarageTemperature(weatherStatRepository.getAvg());
        return weatherStatisticDto;
    }

    @Override
    public WeatherStatisticDto getStatisticFrom(String startDate, String endDate) {
        if (startDate.equals("0" )&& endDate.equals("0")){
            Calendar calendar = Calendar.getInstance();
            endDate = new java.sql.Date(calendar.getTimeInMillis()).toString();
            calendar.add(Calendar.DAY_OF_MONTH, -7);
            startDate = new java.sql.Date(calendar.getTimeInMillis()).toString();
        }

        WeatherStatisticDto weatherStatisticDto = new WeatherStatisticDto() ;
        weatherStatisticDto.setWeatherStatList(weatherStatRepository.getFromPeriod(startDate,endDate));
        weatherStatisticDto.setMaxTemperature(weatherStatRepository.getMaxTempDayFromPeriod(startDate,endDate));
        weatherStatisticDto.setMinTemperature(weatherStatRepository.getMinTempDayFromPeriod(startDate,endDate));
        weatherStatisticDto.setAvarageTemperature(weatherStatRepository.getAvgFromPeriod(startDate,endDate));

        return weatherStatisticDto;
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
