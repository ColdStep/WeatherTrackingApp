package Application.model.WeatherComponent;

import Application.dto.*;

import java.util.List;


// class for parsing Json to Object


public class WeatherResult {
    //Coordinates lon,lat
    private CoordDto coord;
    //list of weather description
    private List<WeatherDto> weather;
    //base
    private String base;
    //About speed
    private WindDto wind;
    // in main description about temperature, humidity, pressure
    private MainInfoDto main;
    //visibility
    private String visibility;
    //clouds density
    private Clouds clouds;
    //about sunset and sunrise
    private SysDto sys;
    //City name
    private String name;
    //City index
    private int id;
    //status code
    private int cod;
    //date
    private long dt;

    public WeatherResult() {
    }

    public CoordDto getCoord() {
        return coord;
    }

    public void setCoord(CoordDto coord) {
        this.coord = coord;
    }

    public List<WeatherDto> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherDto> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public WindDto getWind() {
        return wind;
    }

    public void setWind(WindDto wind) {
        this.wind = wind;
    }

    public MainInfoDto getMain() {
        return main;
    }

    public void setMain(MainInfoDto main) {
        this.main = main;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public SysDto getSys() {
        return sys;
    }

    public void setSys(SysDto sys) {
        this.sys = sys;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }




    class Clouds{

        private String all;

        public Clouds() {
        }

        public String getAll() {
            return all;
        }

        public void setAll(String all) {
            this.all = all;
        }

        @Override
        public String toString() {
            return "Clouds{" +
                    "all='" + all + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WeatherResult{" +
                "coord=" + coord +
                ", weather=" + weather +
                ", base='" + base + '\'' +
                ", wind=" + wind +
                ", main=" + main +
                ", visibility='" + visibility + '\'' +
                ", clouds=" + clouds +
                ", sys=" + sys +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", cod=" + cod +
                ", dt=" + dt +
                '}';
    }
}
