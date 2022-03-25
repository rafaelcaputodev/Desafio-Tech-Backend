package com.caputo.DesafioTechBackend.resources;

import com.caputo.DesafioTechBackend.dtos.GeocodeConsumerDto;
import com.caputo.DesafioTechBackend.services.interfaces.GeoCodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/geoCoding")
public class GeoCodingController {
    private final GeoCodingService geoCodingService;

    @Autowired
    public GeoCodingController(GeoCodingService geoCodingService) {
        this.geoCodingService = geoCodingService;
    }

    @PostMapping
    public List<Double> getGeoCodingForLoc(@RequestBody @Valid GeocodeConsumerDto address) {
        return geoCodingService.getGeoCodingForLoc(address);
    }
}
