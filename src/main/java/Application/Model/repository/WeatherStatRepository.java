package Application.Model.repository;

import Application.Model.entity.WeatherStat;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

//interface to have custom query to DB
public interface WeatherStatRepository extends CrudRepository<WeatherStat,Integer> {

    @Query(value = "select exists (select w.date from weather_stat w where w.date = ?1 and  w.city_name = ?2)",nativeQuery = true)
    java.lang.Number existsByDate(String date , String cityName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE weather_stat w SET w.temperature = ?1, w.weather = ?2 WHERE w.date = ?3 AND  w.city_name = ?4",nativeQuery = true)
    void updateWeather( String temp ,String weather ,String date, String city);

    @Query(value = "SELECT * FROM weather_stat w WHERE w.date BETWEEN ?1 AND ?2 ORDER BY w.date", nativeQuery = true)
    List<WeatherStat> getFromPeriod(String startDate, String endDate);

    @Query(value = "SELECT * FROM weather_stat WHERE weather_stat.temperature = ( SELECT MAX(w.temperature) FROM weather_stat w WHERE  w.date BETWEEN ?1 and ?2)",nativeQuery = true)
    WeatherStat getMaxTempDayFromPeriod(String startDate, String endDate);

    @Query(value = "SELECT * FROM weather_stat WHERE weather_stat.temperature = ( SELECT  MIN(w.temperature) FROM weather_stat w WHERE  w.date BETWEEN ?1 and ?2)",nativeQuery = true)
    WeatherStat getMinTempDayFromPeriod(String startDate, String endDate);

    @Query(value = "SELECT  AVG (w.temperature) FROM  weather_stat w WHERE w.date BETWEEN ?1 AND ?2", nativeQuery = true)
    String getAvgFromPeriod(String startDate, String endDate);

    @Query(value = "SELECT * FROM weather_stat WHERE weather_stat.temperature = ( SELECT MAX(weather_stat.temperature) FROM weather_stat)",nativeQuery = true)
    WeatherStat getMaxTempDay();

    @Query(value = "SELECT * FROM weather_stat WHERE weather_stat.temperature = ( SELECT MIN(weather_stat.temperature) FROM weather_stat)",nativeQuery = true)
    WeatherStat getMinTempDay();

    @Query("select avg (w.temperature) from WeatherStat w")
    String getAvg( );

}
