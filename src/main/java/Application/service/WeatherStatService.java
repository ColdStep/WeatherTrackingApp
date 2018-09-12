package Application.service;

import Application.model.WeatherComponent.WeatherResult;
import Application.model.WeatherComponent.WeatherStatistic;
import Application.model.entity.WeatherStat;

public interface WeatherStatService {

    public WeatherResult getWeather();
    public WeatherStatistic getStatistic();
    public WeatherStatistic getStatisticFrom(String startDate,String endDate);
    public Iterable<WeatherStat> getAll();
    public String deleteAll();

}
