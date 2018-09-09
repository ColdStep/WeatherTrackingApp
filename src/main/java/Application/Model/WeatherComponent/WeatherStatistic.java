package Application.Model.WeatherComponent;

import Application.Model.entity.WeatherStat;

import java.util.List;

//this class was created to have statistic
public class WeatherStatistic {

    List<WeatherStat> weatherStatList;
    WeatherStat minTemperature;
    WeatherStat maxTemperature;
    String avarageTemperature;

    public List<WeatherStat> getWeatherStatList() {
        return weatherStatList;
    }

    public void setWeatherStatList(List<WeatherStat> weatherStatList) {
        this.weatherStatList = weatherStatList;
    }

    public WeatherStat getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(WeatherStat minTemperature) {
        this.minTemperature = minTemperature;
    }

    public WeatherStat getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(WeatherStat maxTemperature) {
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
