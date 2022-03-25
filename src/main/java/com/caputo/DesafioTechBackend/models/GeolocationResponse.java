package com.caputo.DesafioTechBackend.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Data
public class GeolocationResponse {
    private List<Results> results;
    private String status;
}
