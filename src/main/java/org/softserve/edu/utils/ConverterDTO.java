package org.softserve.edu.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.softserve.edu.models.environmentJSON.UsedEnvironment;

import java.io.File;
import java.io.IOException;


public class ConverterDTO {


    private static final Logger LOG = LogManager.getLogger(FileUtils.class.getName());
    private static File JSONFile;
    private static String jsonString;
    private static String prettyJsonString;

    public static void readJSON(String JSONPath){

        JSONFile = FileUtils.readJSONFile(JSONPath);
    }

    public static void convertStringToObject() {

//read parameters from JSON and put them into 2 objects, if JSON is nested -> each part should be a separate object / class

        try {
            ObjectMapper mapper = new ObjectMapper();
            UsedEnvironment environment = mapper.readValue(JSONFile, UsedEnvironment.class);
            LOG.info(environment);

        }catch(JsonProcessingException jsonEx){
            LOG.error("JsonProcessingException " + jsonEx);
            jsonEx.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static <T> T convertStringToObject(Class<T> dtoClass, String content, boolean failOnUnknown) {

        ObjectMapper  dtoObjectMapper = new ObjectMapper ();
        dtoObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, failOnUnknown);

        try {
            return dtoObjectMapper.readValue(content, dtoClass);
        } catch (IOException e) {
            LOG.error(e);
            return null;
        }
    }

    public static String dtoToJsonString(Object dtoClass){

        ObjectMapper objectMapper = new ObjectMapper();

        try{
            jsonString = objectMapper.writeValueAsString(dtoClass);

        }catch (IOException e){
            LOG.error(e);
            e.printStackTrace();
        }
        return jsonString;
    }

    public static String dtoToPrettyJsonString(Object dtoClass){

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

        try{
            prettyJsonString = objectWriter.writeValueAsString(dtoClass);

        }catch (IOException e){
            LOG.error(e);
            e.printStackTrace();
        }
        return prettyJsonString;

    }

    public static void main(String[] args){

        String local =  "src/main/resources/Environments/local/environment.json";
        String qa = "src/main/resources/Environments/qa/environment.json";

        readJSON(local);
        convertStringToObject();

        readJSON(qa);
        convertStringToObject();
    }

}
