package Application.model.entity;


import Application.dto.MainInfoDto;
import Application.dto.WeatherDto;
import Application.model.WeatherComponent.WeatherResult;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.util.List;

//Entity for weather_stat table
@Entity
public  class WeatherStat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String cityName;

    private String country;

    private Date date;

    private int temperature;

    private int humidity;

    private int pressure;

    private String weather;

    private String coord;

    private String wind;

    private int cityCod;

    private Date sunrise;

    private Date senset;




    public WeatherStat() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getCoord() {
        return coord;
    }

    public void setCoord(String coord) {
        this.coord = coord;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public int getCityCod() {
        return cityCod;
    }

    public void setCityCod(int cityCod) {
        this.cityCod = cityCod;
    }

    public Date getSunrise() {
        return sunrise;
    }

    public void setSunrise(Date sunrise) {
        this.sunrise = sunrise;
    }

    public Date getSenset() {
        return senset;
    }

    public void setSenset(Date senset) {
        this.senset = senset;
    }

    @Override
    public String toString() {
        return "WeatherStat{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", country='" + country + '\'' +
                ", date=" + date +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", weather='" + weather + '\'' +
                ", coord='" + coord + '\'' +
                ", wind='" + wind + '\'' +
                ", cityCod=" + cityCod +
                ", sunrise=" + sunrise +
                ", senset=" + senset +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherStat that = (WeatherStat) o;

        if (id != that.id) return false;
        if (cityCod != that.cityCod) return false;
        if (!cityName.equals(that.cityName)) return false;
        return date.equals(that.date);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + cityName.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + cityCod;
        return result;
    }
}

