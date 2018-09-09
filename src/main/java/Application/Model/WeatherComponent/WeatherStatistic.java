package Application.Model.WeatherComponent;

import Application.Model.entity.WeatherStat;

public class WeatherStatistic {

    WeatherStat minTemperature;
    WeatherStat maxTemperature;
    String avarageTemperature;

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
        return "WeatherStatistic{" +
                "minTemperature=" + minTemperature +
                ", maxTemperature=" + maxTemperature +
                ", avarageTemperature='" + avarageTemperature + '\'' +
                '}';
    }
}
