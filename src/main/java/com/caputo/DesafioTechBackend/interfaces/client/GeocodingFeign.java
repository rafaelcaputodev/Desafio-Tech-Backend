package com.caputo.DesafioTechBackend.interfaces.client;

import com.caputo.DesafioTechBackend.models.GeolocationResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "geocoding", url = "${geocoding}")
public interface GeocodingFeign {

    @GetMapping
    @RequestLine(" GET /{address}")
    ResponseEntity<GeolocationResponse> getGeocoding(@Param java.net.URI address);
}
