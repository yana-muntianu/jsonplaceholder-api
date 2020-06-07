package org.softserve.edu.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.softserve.edu.models.environmentJSON.Environment;

import java.io.File;
import java.io.IOException;


public class ConverterDTO {

    private static final Logger LOG = LogManager.getLogger(FileUtils.class.getName());
    private static File JSONFile;

    public void readJSON(String JSONPath){
/*
read JSON file using FileUtils file reader
 */
        FileUtils fileUtils = new FileUtils();
        JSONFile = fileUtils.readJSONFile(JSONPath);
    }

    public void convertStringToObject() {
/*
read parameters from JSON and put them into 2 objects
if JSON is nested -> each part should be a separate object / class
 */
        try {
            ObjectMapper mapper = new ObjectMapper();
            Environment environment = mapper.readValue(JSONFile, Environment.class);
            LOG.info(environment);

        }catch(JsonProcessingException jsonEx){
            LOG.error("JsonProcessingException " + jsonEx);
            jsonEx.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        ConverterDTO converterDTO = new ConverterDTO();

        String local =  "src/main/resources/Environments/local/environment.json";
        String qa = "src/main/resources/Environments/qa/environment.json";

        converterDTO.readJSON(local);
        converterDTO.convertStringToObject();

        converterDTO.readJSON(qa);
        converterDTO.convertStringToObject();
    }

}
