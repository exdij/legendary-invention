package kc.province_identifier;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class Endpoints {
    @GetMapping(value="/u")
    public ResponseEntity<String> getKey(){
        PropertiesReader props = new PropertiesReader();
        return ResponseEntity.ok()
                .body(System.getenv("APP_KEY"));
    }

    @PostMapping(value="/secret")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
        CSVFileParser parser = new CSVFileParser();
        parser.readCSV(file);
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
