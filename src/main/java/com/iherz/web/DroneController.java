package com.iherz.web;

import com.iherz.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class DroneController {

    @Autowired
    private DroneService droneService;

    @RequestMapping(value = "urbanizaciones", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<String>> media(final @RequestParam Long latitud, final @RequestParam Long longitud,
                                             final @RequestParam Integer rango) {

        return new ResponseEntity<>(droneService.obtenerUrbanizaciones(latitud, longitud, rango), HttpStatus.OK);
    }

}
