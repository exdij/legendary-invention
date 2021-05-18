package kc.province_identifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Endpoints {
    @Autowired
    private CityRepository cityRepository;

    @GetMapping(value="/test")
    public ResponseEntity<List<City>> getId(@RequestHeader String name){
        List<City> test = new ArrayList<>();
        test = cityRepository.findIdByName("skoczów");
        return ResponseEntity.ok()
                .body(test);
    }

//    @PostMapping(value="/secret")
//    public ResponseEntity<String> uploadFile(@RequestHeader("key") String key, @RequestParam("file") MultipartFile file){
//        CSVFileParser parser = new CSVFileParser();
//        parser.readCSV(file);
//        if(key != System.getenv("APP_KEY")) {
//            return ResponseEntity.status(403)
//                    .body("ok");
//        } else {
//            return ResponseEntity.ok()
//                    .body("");
//        }
//    }

    @PostMapping(value="/test")
    public ResponseEntity<String> testadd(@RequestParam("file") MultipartFile file){
        CSVFileParser parser = new CSVFileParser();
        cityRepository.saveAll(parser.readCSV(file));
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
