package kc.province_identifier.entities;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Persistable;

import javax.persistence.Id;
import javax.persistence.Entity;


@Setter
@Getter
@Entity
public class City implements Persistable<Integer> {
    @Id
    private Integer id;
    private String name;
    private String district;
    private String province;
    private String commune;

    public City() { }
    public City(Integer cityId, String name, String district, String province, String commune){
        this.id = cityId;
        this.name = name;
        this.district = district;
        this.province = province;
        this.commune = commune;
    }
    @Override
    public boolean isNew(){
        return true;
    }


}
