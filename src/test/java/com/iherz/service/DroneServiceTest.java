package com.iherz.service;

import com.iherz.model.Direccion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

public class DroneServiceTest {

    @InjectMocks
    private DroneService droneService;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void generarListaMovimientosTestRango1() {
        List<Direccion> direcciones = droneService.generarListaMovimientos(1);
        assertEquals(direcciones.get(0), Direccion.ARRIBA);
        assertEquals(direcciones.get(1), Direccion.DERECHA);
        assertEquals(direcciones.get(2), Direccion.ABAJO);
        assertEquals(direcciones.get(3), Direccion.ABAJO);
        assertEquals(direcciones.get(4), Direccion.IZQUIERDA);
        assertEquals(direcciones.get(5), Direccion.IZQUIERDA);
        assertEquals(direcciones.get(6), Direccion.ARRIBA);
        assertEquals(direcciones.get(7), Direccion.ARRIBA);
        assertEquals(direcciones.get(8), Direccion.DERECHA);
    }

    @Test
    public void generarListaMovimientosTestRango2() {
        List<Direccion> direcciones = droneService.generarListaMovimientos(2);
        assertEquals(direcciones.get(0), Direccion.ARRIBA);
        assertEquals(direcciones.get(1), Direccion.DERECHA);
        assertEquals(direcciones.get(2), Direccion.DERECHA);
        assertEquals(direcciones.get(3), Direccion.ABAJO);
        assertEquals(direcciones.get(4), Direccion.ABAJO);
        assertEquals(direcciones.get(5), Direccion.ABAJO);
        assertEquals(direcciones.get(6), Direccion.ABAJO);
        assertEquals(direcciones.get(7), Direccion.IZQUIERDA);
        assertEquals(direcciones.get(8), Direccion.IZQUIERDA);
        assertEquals(direcciones.get(9), Direccion.IZQUIERDA);
        assertEquals(direcciones.get(10), Direccion.IZQUIERDA);
        assertEquals(direcciones.get(11), Direccion.ARRIBA);
        assertEquals(direcciones.get(12), Direccion.ARRIBA);
        assertEquals(direcciones.get(13), Direccion.ARRIBA);
        assertEquals(direcciones.get(14), Direccion.ARRIBA);
        assertEquals(direcciones.get(15), Direccion.DERECHA);
        assertEquals(direcciones.get(16), Direccion.DERECHA);
    }
}
