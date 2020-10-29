package com.example.demo.model;

import com.example.demo.common.utils.ObjectMapperUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Embedded {
    @JsonProperty("locations")
    private List<Location> locationList;

    @Override
    public String toString() {
        return ObjectMapperUtils.getStrFromObj(this);
    }
}
