package com.iherz.service;

import com.iherz.model.Direccion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class DroneService {

    public Set<String> obtenerUrbanizaciones(final Long longitud, final Long latitud, Integer rango) {
        Set<String> urbanizaciones = new HashSet<>();
        String urb = obtenerIdentificadorUrbanizacion(longitud, latitud);
        urbanizaciones.add(urb);
        for (int index = 1 ; index <= rango ; index++) {
            for (Direccion direccion : generarListaMovimientos(index)) {
                urb = new String(obtenerAdyacente(urb, direccion));
                if (!urbanizaciones.contains(urb)) {
                    urbanizaciones.add(urb);
                }
            }
        }
        return urbanizaciones;
    }

    public List<Direccion> generarListaMovimientos(final Integer rango) {
        List<Direccion> mapaMovimientos = new ArrayList<>();
        mapaMovimientos.add(Direccion.ARRIBA);
        mapaMovimientos.addAll(generarDerecha(rango));
        mapaMovimientos.addAll(generarAbajoIzqArriba(rango, Direccion.ABAJO));
        mapaMovimientos.addAll(generarAbajoIzqArriba(rango, Direccion.IZQUIERDA));
        mapaMovimientos.addAll(generarAbajoIzqArriba(rango, Direccion.ARRIBA));
        mapaMovimientos.addAll(generarDerecha(rango));
        return mapaMovimientos;
    }

    private List<Direccion> generarDerecha(final Integer rango) {
        List<Direccion> movs = new ArrayList<>();
        for (int index = 0 ; index < rango ; index++) {
            movs.add(Direccion.DERECHA);
        }
        return movs;
    }

    private List<Direccion> generarAbajoIzqArriba(final Integer rango, final Direccion direccion) {
        List<Direccion> movs = new ArrayList<>();
        for (int index = 0 ; index < rango * 2 ; index++) {
            movs.add(direccion);
        }
        return movs;
    }

    private String obtenerAdyacente(final String id, final Direccion direccion) {
        return UUID.randomUUID().toString();
    }

    private String obtenerIdentificadorUrbanizacion(final Long longitud, final Long latitud) {
        return new String("ORIGEN");
    }
}
