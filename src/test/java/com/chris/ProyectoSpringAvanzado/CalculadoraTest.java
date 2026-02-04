package com.chris.ProyectoSpringAvanzado;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.chris.ProyectoSpringAvanzado.dto.Calculadora;

public class CalculadoraTest {

    @Test
    void contextLoads() {

        // pruebas unitarias solo con junit
        Calculadora calculadora = new Calculadora();

        assertEquals(10, calculadora.suma(5, 5));
        assertEquals(10, calculadora.resta(15, 5));

    }

}
