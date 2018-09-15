package Application.service;

import Application.dto.WeatherStatisticDto;
import Application.model.WeatherComponent.WeatherResult;
import Application.model.entity.WeatherStat;

public interface WeatherStatService {

    public WeatherResult getWeather();
    public WeatherStatisticDto getStatistic();
    public WeatherStatisticDto getStatisticFrom(String startDate, String endDate);
    public Iterable<WeatherStat> getAll();
    public String deleteAll();

}
