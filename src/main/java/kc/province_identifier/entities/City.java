package kc.province_identifier.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Persistable;


import javax.persistence.Id;
import javax.persistence.Entity;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@Entity
public class City implements Persistable<Integer> {
    @Id
    private Integer id;
    private String name;
    private String district;
    private String province;
    private String commune;

    public City() { }
    @Override
    public boolean isNew(){
        return true;
    }


}
