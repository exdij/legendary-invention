package kc.province_identifier.entities;

import kc.province_identifier.entities.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepository extends CrudRepository<City, Integer> {
    List<City> findByNameContainingIgnoreCase(String name);
}
