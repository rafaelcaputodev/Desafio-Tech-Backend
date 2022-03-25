package com.caputo.DesafioTechBackend.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Data
public class Results {
    private List<AddressComponent> address_components;
    private String formatted_address;
    private Geometry geometry;
    private String place_id;
    private PlusCode plus_code;
    private Object types;
}
