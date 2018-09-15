package Application.dto;

import Application.model.entity.WeatherStat;

import java.util.List;

//this class was created to have statistic
public class WeatherStatisticDto {

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
        return "WeatherStatisticDto{" +
                "weatherStatList=" + weatherStatList +
                ", minTemperature=" + minTemperature +
                ", maxTemperature=" + maxTemperature +
                ", avarageTemperature='" + avarageTemperature + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherStatisticDto that = (WeatherStatisticDto) o;

        if (weatherStatList != null ? !weatherStatList.equals(that.weatherStatList) : that.weatherStatList != null)
            return false;
        if (minTemperature != null ? !minTemperature.equals(that.minTemperature) : that.minTemperature != null)
            return false;
        if (maxTemperature != null ? !maxTemperature.equals(that.maxTemperature) : that.maxTemperature != null)
            return false;
        return avarageTemperature != null ? avarageTemperature.equals(that.avarageTemperature) : that.avarageTemperature == null;
    }

    @Override
    public int hashCode() {
        int result = weatherStatList != null ? weatherStatList.hashCode() : 0;
        result = 31 * result + (minTemperature != null ? minTemperature.hashCode() : 0);
        result = 31 * result + (maxTemperature != null ? maxTemperature.hashCode() : 0);
        result = 31 * result + (avarageTemperature != null ? avarageTemperature.hashCode() : 0);
        return result;
    }
}
