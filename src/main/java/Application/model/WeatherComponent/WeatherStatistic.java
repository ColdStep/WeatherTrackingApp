package Application.model.WeatherComponent;

import Application.model.entity.WeatherStat;

import java.util.List;

//this class was created to have statistic
public class WeatherStatistic {

    private List<WeatherStat> weatherStatList;
    private List<WeatherStat> minTemperature;
    private List<WeatherStat> maxTemperature;
    private String avarageTemperature;

    public List<WeatherStat> getWeatherStatList() {
        return weatherStatList;
    }

    public void setWeatherStatList(List<WeatherStat> weatherStatList) {
        this.weatherStatList = weatherStatList;
    }

    public List<WeatherStat> getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(List<WeatherStat> minTemperature) {
        this.minTemperature = minTemperature;
    }

    public List<WeatherStat> getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(List<WeatherStat> maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public String getAvarageTemperature() {
        return avarageTemperature;
    }

    public void setAvarageTemperature(String avarageTemperature) {
        this.avarageTemperature = avarageTemperature;
    }

    @Override
    public String toString() {
        System.out.println("Boom");
        return "WeatherStatistic{" +
                "weatherStatList=" + weatherStatList.toString() +
                ", minTemperature=" + minTemperature.toString() +
                ", maxTemperature=" + maxTemperature.toString() +
                ", avarageTemperature='" + avarageTemperature + '\'' +
                '}';
    }
}
