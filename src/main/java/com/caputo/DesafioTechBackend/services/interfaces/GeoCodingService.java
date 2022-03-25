package com.caputo.DesafioTechBackend.services.interfaces;

import com.caputo.DesafioTechBackend.dtos.GeocodeConsumerDto;

import java.util.List;

public interface GeoCodingService {

    List<Double> getGeoCodingForLoc(GeocodeConsumerDto address);
}
