
import Application.model.WeatherComponent.WeatherResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.MalformedURLException;

public class Test {

    public static void main(String[] args) {
//        String s = "{\"weatherStatList\":[{\"id\":2,\"cityName\":\"Lviv\",\"date\":\"сен 10, 2018\",\"temperature\":\"20\",\"weather\":\"Sunrise - Sun Sep 09 06:51:26 EEST 2018\"},{\"id\":3,\"cityName\":\"Lviv\",\"date\":\"сен 11, 2018\",\"temperature\":\"21\",\"weather\":\"Sunrise - Sun Sep 09 06:51:26 EEST 2018\"},{\"id\":4,\"cityName\":\"Lviv\",\"date\":\"сен 12, 2018\",\"temperature\":\"32\",\"weather\":\"Sunrise - Sun Sep 09 06:51:26 EEST 2018\"},{\"id\":5,\"cityName\":\"Lviv\",\"date\":\"сен 13, 2018\",\"temperature\":\"12\",\"weather\":\"Sunrise - Sun Sep 09 06:51:26 EEST 2018\"},{\"id\":6,\"cityName\":\"Lviv\",\"date\":\"сен 14, 2018\",\"temperature\":\"23\",\"weather\":\"Sunrise - Sun Sep 09 06:51:26 EEST 2018\"}],\"minTemperature\":{\"id\":5,\"cityName\":\"Lviv\",\"date\":\"сен 13, 2018\",\"temperature\":\"12\",\"weather\":\"Sunrise - Sun Sep 09 06:51:26 EEST 2018\"},\"maxTemperature\":{\"id\":4,\"cityName\":\"Lviv\",\"date\":\"сен 12, 2018\",\"temperature\":\"32\",\"weather\":\"Sunrise - Sun Sep 09 06:51:26 EEST 2018\"},\"avarageTemperature\":\"21.6\"}";
        RestTemplate restTemplate = new RestTemplate();
        String temp = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q=lviv&APPID=4bb9969e1d07e6dd69a8824e9f15f358&units=metric",
                String.class);

//        WeatherStatisticDto weatherStatistic = new Gson().fromJson(s,WeatherStatisticDto.class);
//
//        System.out.println(weatherStatistic.toString());
//
//
//        Calendar calendar = Calendar.getInstance();
//        String startDate = new java.sql.Date(calendar.getTimeInMillis()).toString();
//        calendar.add(Calendar.DAY_OF_MONTH, -7);
//        String endDate = new java.sql.Date(calendar.getTimeInMillis()).toString();
//
//        System.out.println("Start - " +startDate);
//        System.out.println("end - "+endDate);

//        WeatherDto weatherDto = new WeatherDto();
//        weatherDto.setId(1);
//        weatherDto.setCityName("lviv");
//        weatherDto.setTemperature("12");
//        weatherDto.setWeather("sunny");
//
//
        try {

//            Object object = new ObjectMapper().readValue(temp,Object.class);
//            System.out.println(object);
//            System.out.println(new ObjectMapper().writeValueAsString(object));

            WeatherResult weatherResult = new ObjectMapper().readValue(temp,WeatherResult.class);
            System.out.println(weatherResult.toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
