package com.caputo.DesafioTechBackend.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class Geometry {
    private Location location;
    private String location_type;
    private ViewPort viewport;
}
