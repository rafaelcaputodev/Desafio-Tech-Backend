package com.caputo.DesafioTechBackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeocodeConsumerDto implements Serializable {
    private static final Long serialVersionUID = 1L;

    private List<String> address;

    public List<String> getAddress() {
        if(this.address == null){
            this.address = new ArrayList<>();
        }
        return address;
    }
}
