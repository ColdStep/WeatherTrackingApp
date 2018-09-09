//import Application.Model.WeatherComponent.WeatherStatistic;
//import Application.Model.entity.WeatherStat;
//import com.google.gson.Gson;
//
//import java.util.Calendar;
//
//public class Test {
//
//    public static void main(String[] args) {
//        String s = "{\"weatherStatList\":[{\"id\":2,\"cityName\":\"Lviv\",\"date\":\"сен 10, 2018\",\"temperature\":\"20\",\"weather\":\"Sunrise - Sun Sep 09 06:51:26 EEST 2018\"},{\"id\":3,\"cityName\":\"Lviv\",\"date\":\"сен 11, 2018\",\"temperature\":\"21\",\"weather\":\"Sunrise - Sun Sep 09 06:51:26 EEST 2018\"},{\"id\":4,\"cityName\":\"Lviv\",\"date\":\"сен 12, 2018\",\"temperature\":\"32\",\"weather\":\"Sunrise - Sun Sep 09 06:51:26 EEST 2018\"},{\"id\":5,\"cityName\":\"Lviv\",\"date\":\"сен 13, 2018\",\"temperature\":\"12\",\"weather\":\"Sunrise - Sun Sep 09 06:51:26 EEST 2018\"},{\"id\":6,\"cityName\":\"Lviv\",\"date\":\"сен 14, 2018\",\"temperature\":\"23\",\"weather\":\"Sunrise - Sun Sep 09 06:51:26 EEST 2018\"}],\"minTemperature\":{\"id\":5,\"cityName\":\"Lviv\",\"date\":\"сен 13, 2018\",\"temperature\":\"12\",\"weather\":\"Sunrise - Sun Sep 09 06:51:26 EEST 2018\"},\"maxTemperature\":{\"id\":4,\"cityName\":\"Lviv\",\"date\":\"сен 12, 2018\",\"temperature\":\"32\",\"weather\":\"Sunrise - Sun Sep 09 06:51:26 EEST 2018\"},\"avarageTemperature\":\"21.6\"}";
//
//        WeatherStatistic weatherStatistic = new Gson().fromJson(s,WeatherStatistic.class);
//
////        System.out.println(weatherStatistic.toString());
//
//
//        Calendar calendar = Calendar.getInstance();
//        String startDate = new java.sql.Date(calendar.getTimeInMillis()).toString();
//        calendar.add(Calendar.DAY_OF_MONTH, -7);
//        String endDate = new java.sql.Date(calendar.getTimeInMillis()).toString();
//
//        System.out.println("Start - " +startDate);
//        System.out.println("end - "+endDate);
//
//
//    }
//}
