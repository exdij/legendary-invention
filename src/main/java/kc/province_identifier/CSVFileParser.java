package kc.province_identifier;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.Charset;

public class CSVFileParser {
    public void readCSV(MultipartFile file){
        try {
            Charset inputCharset = Charset.forName("windows-1250");
            BufferedReader csvReader = new BufferedReader(new InputStreamReader(file.getInputStream(),inputCharset));
            String row;
            String[] row_splitted;
            String current_district = "";
            String current_province = "";
            int city_id;
            String commune = "";
            while((row = csvReader.readLine()) != null){
                if(row.contains("WOJEWÓDZTWO")){
                    row = row.split(" ")[1].split(";")[0];
                    current_district = row.substring(0,1) + row.substring(1).toLowerCase();
                } else if(row.contains("Powiat")){
                    row = row.split(" ")[1].split(";")[0];
                    current_province = row.substring(0,1).toUpperCase() + row.substring(1);
                } else if(row.contains("Gmin")){
                    commune = row.split(":")[0];
                    if (commune == "Gminy") commune = "Gmina";
                } else if((row_splitted = row.split(";")).length > 1){
                    if((city_id = parseInt(row_splitted[1])) != 0){
                        if(row_splitted.length > 2) {
                            if (row_splitted[2].contains("przywrócony") || !row_splitted[2].contains("kod") && !row_splitted[2].contains("obowiązywał")) {
                                System.out.println(current_district + " " + current_province + " " + row_splitted[0] + " " + commune + " " + city_id + " " + row_splitted[2]);
                            }
                        }
                        else {
                            System.out.println(current_district + " " + current_province + " " + row_splitted[0] + " " + commune + " " + city_id);
                        }
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

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
