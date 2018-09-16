package Application.service;

import Application.dto.WeatherStatisticDto;
import Application.model.WeatherComponent.WeatherResult;
import Application.model.entity.WeatherStat;

public interface WeatherStatService {

    WeatherResult getWeather();
    WeatherStatisticDto getStatistic();
    WeatherStatisticDto getStatisticFrom(String startDate, String endDate);
    Iterable<WeatherStat> getAll();
    String deleteAll();

}
