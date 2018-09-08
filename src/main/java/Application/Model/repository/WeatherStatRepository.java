package Application.Model.repository;

import Application.Model.entity.WeatherStat;
import org.springframework.data.repository.CrudRepository;

public interface WeatherStatRepository extends CrudRepository<WeatherStat,Integer> {

}
