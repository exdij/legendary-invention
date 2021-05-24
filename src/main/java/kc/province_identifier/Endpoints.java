package kc.province_identifier;

import kc.province_identifier.entities.City;
import kc.province_identifier.entities.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class Endpoints {
    @Autowired
    private CityRepository cityRepository;

    @CrossOrigin()
    @GetMapping(value="/get_id")
    public ResponseEntity<List<City>> getId(@RequestParam String name){
        List<City> cityList;
        cityList = cityRepository.findIdByName(name);
        return ResponseEntity.ok()
                .body(cityList);
    }


    @PostMapping(value="/save")
    public ResponseEntity<String> addCity(@RequestParam("file") MultipartFile file, @RequestHeader("app_key") String appKey){
        String envkey = System.getenv("APP_KEY");
        if(!appKey.equals(envkey)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("");
        }
        CSVFileParser parser = new CSVFileParser();
        cityRepository.saveAll(parser.readCSV(file));
        return ResponseEntity.ok()
                .body("ok");
    }

    @GetMapping(value="/")
    public ResponseEntity<String> ping(){
        return ResponseEntity.ok()
                .body("Hello there");
    }
}
