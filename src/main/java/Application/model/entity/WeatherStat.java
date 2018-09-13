package Application.model.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

//Entity for weather_stat table
@Entity
public  class WeatherStat {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String cityName;

    private Date date;

    private String temperature;

    private String weather;


    public WeatherStat() {
    }


    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "WeatherStat{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", date=" + date +
                ", temperature='" + temperature + '\'' +
                ", weather='" + weather + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherStat that = (WeatherStat) o;

        if (id != that.id) return false;
        if (!cityName.equals(that.cityName)) return false;
        return date.equals(that.date);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + cityName.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }
}

