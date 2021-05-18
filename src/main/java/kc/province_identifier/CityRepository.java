package kc.province_identifier;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface CityRepository extends CrudRepository<City, Integer> {
    @Query("SELECT c FROM City c WHERE c.name LIKE %?1%")
    List<City> findIdByName(String name);
}
