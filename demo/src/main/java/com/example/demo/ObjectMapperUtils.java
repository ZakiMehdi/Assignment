package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ObjectMapperUtils {

    private static final ObjectMapper mapper = new ObjectMapper()
            .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private ObjectMapperUtils(){}

    public static ObjectMapper getInstance() {
        return mapper;
    }

    public static String getStrFromObj(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException ex) {
           // log.error("Error while parsing Object {} Exception {}", obj.toString(), ex);
        }
        return "";
    }

    public static <T> T getObjFromStr(String strObj, Class<T> resClass) {
        try {
            return mapper.readValue(strObj, resClass);
        } catch (JsonProcessingException ex) {
            //log.error("Error while parsing String {} Exception {}", strObj, ex);
        }
        return null;
    }

}
