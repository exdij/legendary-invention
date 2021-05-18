package kc.province_identifier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.Query;

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
