package com.example.demo.model;

import com.example.demo.common.utils.ObjectMapperUtils;

import lombok.Data;
import lombok.Value;

@Data
public class Coordinates {
    private double latitude, longitude;

    @Override
    public String toString() {
        return ObjectMapperUtils.getStrFromObj(this);
    }
}
