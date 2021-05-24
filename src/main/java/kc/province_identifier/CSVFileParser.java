package kc.province_identifier;

import kc.province_identifier.entities.City;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class CSVFileParser {
    public List<City> readCSV(MultipartFile file){
        String row;
        String[] row_splitted;
        String district = "";
        String province = "";
        Integer city_id;
        String commune = "";
        List<City> cityList = new ArrayList<City>();

        try {
            Charset inputCharset = Charset.forName("windows-1250");
            BufferedReader csvReader = new BufferedReader(new InputStreamReader(file.getInputStream(),inputCharset));

            while((row = csvReader.readLine()) != null){
                if(row.contains("WOJEWÓDZTWO")){
                    row = row.split(" ")[1].split(";")[0];
                    district = row.substring(0,1) + row.substring(1).toLowerCase();
                } else if(row.contains("Powiat")){
                    row = row.split(" ")[1].split(";")[0];
                    province = row.substring(0,1).toUpperCase() + row.substring(1);
                } else if(row.contains("Gmin")){
                    commune = row.split(":")[0];
                    if (commune.equals("Gminy")) commune = "Gmina";
                    else if(commune.equals("Gminy miejskie")) commune = "Gmina miejska";
                } else if((row_splitted = row.split(";")).length > 1){
                    if((city_id = parseInt(row_splitted[1])) != 0){
                        if(row_splitted.length > 2) {
                            if (row_splitted[2].contains("przywrócony") || !row_splitted[2].contains("kod") && !row_splitted[2].contains("obowiązywał")) {
                                cityList.add(new City(city_id, row_splitted[0],district,province,commune));
                            }
                        }
                        else {
                            cityList.add(new City(city_id, row_splitted[0],district,province,commune));
                        }
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cityList;
    }

    private int parseInt(String input){
        int value;
        try{
            value = Integer.parseInt(input.replace(" ",""));
        } catch(NumberFormatException e){
            value = 0;
        }
        return value;
    }

}
