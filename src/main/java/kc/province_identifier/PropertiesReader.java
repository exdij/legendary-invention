package kc.province_identifier;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    Properties properties = new Properties();
    public PropertiesReader(){
        try{
            InputStream input = PropertiesReader.class.getClassLoader().getResourceAsStream("apikey.properties");
            properties.load(input);
            }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public String getProp(String propName){
        return properties.getProperty(propName);
    }

}
