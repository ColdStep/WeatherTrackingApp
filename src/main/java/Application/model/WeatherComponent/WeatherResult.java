package Application.model.WeatherComponent;

// class for parsing Json to Object
public class WeatherResult {
    Coord coord;
    Weather[] weather;
    Wind wind;
    MainInfo main;
    Sys sys;
    //City
    String name;
    //City index
    int id;
    //status code
    int cod;
    //date
    long dt;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getCod() {
        return cod;
    }



    public java.sql.Date getDt() {

        return new java.sql.Date(new java.util.Date(dt*1000).getTime());
    }

    public String getCoord() {
        return "Lon - "+ coord.getLon() +"\n" +
                "Lat - "+ coord.getLat()+"\n";
    }

    public String getWeather() {
        String result =null;
        for (Weather wth : weather) {
            result = "Weather:\n" +
                    " Main: " + wth.getMain() + "\n" +
                    " Description: " + wth.getDescription() + "\n";
        }

        return result;
    }


    public String getWind() {
        return "Wind: \n" +
                 " Speed - "+wind.getSpeed()+"meter/sec\n" +
                " Direction - "+ wind.getDeg()+"degree\n";
    }


    public String getMainInfo() {
        return "Temperature - "+ main.getTemp()+"C\n" +
                "Max temperature - " + main.getTempMax()+"C\n" +
                "Min temperature - " + main.getTempMin() + "C\n" +
                "Pressure - " + main.getPressure()+"hPa\n"+
                "Humidity - " + main.getHumidity()+"%\n";
    }

    public String getMain() {
        return main.getTemp();
    }

    public String getSys() {
        return "Sunrise - "+new java.util.Date((long)sys.getSunrise()*1000)+"\n" +
                "Sunset - "+new java.util.Date((long)sys.getSunset()*1000) +"\n";
    }




    class Coord{
        String lon;
        String lat;

        public String getLon() {
            return lon;
        }


        public String getLat() {
            return lat;
        }


    }

    class Weather{
        String id;
        String main;
        String description;
        String icon;

        public String getId() {
            return id;
        }

        public String getMain() {
            return main;
        }

        public String getDescription() {
            return description;
        }

        public String getIcon() {
            return icon;
        }
    }
    class Wind{
        String speed;
        String deg;

        public String getSpeed() {
            return speed;
        }

        public String getDeg() {
            return deg;
        }
    }
    class MainInfo{
        String temp;
        String pressure;
        String humidity;
        String temp_min;
        String temp_max;

        public String getTemp() {
            return temp;
        }

        public String getPressure() {
            return pressure;
        }

        public String getHumidity() {
            return humidity;
        }

        public String getTempMin() {
            return temp_min;
        }

        public String getTempMax() {
            return temp_max;
        }
    }
    class Sys{
        int sunrise;
        int sunset;
        public int getSunrise() {
            return sunrise;
        }

        public int getSunset() {
            return sunset;
        }

    }

    @Override
    public String toString() {
        return "[    "+getName()+"    ]\n" +
                getSys()+
                getMainInfo()+
                getWeather()+
                getWind();
    }

}
