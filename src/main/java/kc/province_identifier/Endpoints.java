package kc.province_identifier;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Endpoints {
    @GetMapping(value="u")
    public ResponseEntity<String> getKey(){
        PropertiesReader props = new PropertiesReader();

        return ResponseEntity.ok()
                .body(props.getProp("APP_KEY"));
    }
}
