package com.caputo.DesafioTechBackend.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class AddressComponent {
    private String long_name;
    private String short_name;
    private Object types;
}
