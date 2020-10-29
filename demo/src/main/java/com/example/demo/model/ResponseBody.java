package com.example.demo.model;

import com.example.demo.ObjectMapperUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseBody {
    @JsonProperty("_embedded")
    private Embedded embedded;

    @Override
    public String toString() {
        return ObjectMapperUtils.getStrFromObj(this);
    }
}
