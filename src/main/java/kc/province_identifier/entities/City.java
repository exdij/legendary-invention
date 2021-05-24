package kc.province_identifier.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.Id;
import javax.persistence.Entity;

@Setter
@Getter
@AllArgsConstructor
@Entity
public class City {
    @Id
    private Integer id;
    private String name;
    private String district;
    private String province;
    private String commune;

    public City() { }


}
