package kc.province_identifier;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Endpoints {
    @GetMapping(value="/u")
    public ResponseEntity<String> getKey(){
        PropertiesReader props = new PropertiesReader();
        return ResponseEntity.ok()
                .body(System.getenv("APP_KEY"));
    }

    @GetMapping(value="/secret")
    public ResponseEntity<String> readFile(){
        CSVFileParser parser = new CSVFileParser();
        parser.readCSV();
        return ResponseEntity.ok()
                .body("ok");
    }

    @GetMapping(value="/")
    public ResponseEntity<String> ping(){
        PropertiesReader props = new PropertiesReader();

        return ResponseEntity.ok()
                .body("Hello there");
    }
}
