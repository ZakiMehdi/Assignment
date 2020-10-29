package com.example.demo.model;

import com.example.demo.ObjectMapperUtils;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Set;

import lombok.Data;
import lombok.Value;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
@Data
public class Location {

    private String code, name, description;
    private Coordinates coordinates;
    private Location parent;
    private Set<Location> children;

    @Override
    public String toString() {
        return ObjectMapperUtils.getStrFromObj(this);
    }

}
