package Application.Model.repository;

import Application.Model.entity.WeatherStat;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

public interface WeatherStatRepository extends CrudRepository<WeatherStat,Integer> {

    @Query(value = "select exists (select w.date from weather_stat w where w.date = ?1 and  w.city_name = ?2)",nativeQuery = true)
    java.lang.Number existsByDate(String date , String cityName);

    @Transactional
    @Modifying
    @Query(value = "update weather_stat w set w.temperature = ?1, w.weather = ?2 where w.date = ?3 and  w.city_name = ?4",nativeQuery = true)
    void updateWeather( String temp ,String weather ,String date, String city);

    @Query(value = "SELECT * FROM weather_stat where weather_stat.temperature = ( select max(weather_stat.temperature) FROM weather_stat)",nativeQuery = true)
    WeatherStat getMaxTempDay();

    @Query(value = "SELECT * FROM weather_stat where weather_stat.temperature = ( select min(weather_stat.temperature) FROM weather_stat)",nativeQuery = true)
    WeatherStat getMinTempDay();

    @Query("select min (w.temperature) from WeatherStat w")
    String getMin( );
    @Query("select max (w.temperature) from WeatherStat w")
    String getMax( );
    @Query("select avg (w.temperature) from WeatherStat w")
    String getAvg( );

}
