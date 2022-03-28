package com.caputo.DesafioTechBackend.services.impl;

import com.caputo.DesafioTechBackend.dtos.GeocodeConsumerDto;
import com.caputo.DesafioTechBackend.interfaces.client.GeocodingFeign;
import com.caputo.DesafioTechBackend.models.GeolocationResponse;
import com.caputo.DesafioTechBackend.models.Results;
import com.caputo.DesafioTechBackend.services.interfaces.GeoCodingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GeoCodingServiceImpl implements GeoCodingService {

    private static Logger logger = LoggerFactory.getLogger(GeoCodingServiceImpl.class);
    List<Double> resultsDistance = new ArrayList<>();

    @Value("${key}")
    private String key;

    @Value("${geocoding}")
    private String url;

    @Autowired
    private GeocodingFeign geocodingFeign;

    @Override
    public List<Double> getGeoCodingForLoc(GeocodeConsumerDto address) {
        address.getAddress().forEach(x -> {
            x = concatenatingUrl(x);

            GeolocationResponse geolocationResponse = sendingFeign(x);

            geolocationResponse.getResults().forEach(this::euclideanDistanceCalculation);
        });

        Collections.sort(resultsDistance);
        return resultsDistance;
    }

    public GeolocationResponse sendingFeign(String address){
        logger.info("Buscando geolocalização...");
        GeolocationResponse geolocationResponse = geocodingFeign.getGeocoding(URI.create(address)).getBody();
        if(geolocationResponse == null){
            throw new RuntimeException("Não foi possível obter a geolocalização!");
        }
        logger.info("Geolocalização encontrada!");
        return geolocationResponse;
    }

    public String concatenatingUrl(String address){
        return url + address.replace(" ", "+") + "&key=" + key;
    }

    public void euclideanDistanceCalculation(Results results) {
        Long lat1 = results.getGeometry().getViewport().getNortheast().getLat();
        Long lng1 = results.getGeometry().getViewport().getNortheast().getLng();

        Long lat2 = results.getGeometry().getViewport().getSouthwest().getLat();
        Long lng2 = results.getGeometry().getViewport().getSouthwest().getLng();

        if ((lat1 == lat2) && (lng1 == lng2)) {
            throw new RuntimeException("same location!");
        } else {
            double theta = lng1 - lng2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            resultsDistance.add(dist);
        }
    }
}
