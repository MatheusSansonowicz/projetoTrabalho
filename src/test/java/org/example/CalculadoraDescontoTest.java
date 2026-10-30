package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraDescontoTest {

    private final CalculadoraDesconto calculadora =
            new CalculadoraDesconto();

    // ===== VALOR DA COMPRA =====

    @Test
    void calcularValorCompraMenosCincoLancaIllegalArgumentException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.calcular(-5, 10)
        );
    }

    @Test
    void calcularValorCompraMenosUmLancaIllegalArgumentException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.calcular(-1, 10)
        );
    }

    @Test
    void calcularValorCompraZeroPercentualDezRetornaZero() {
        assertEquals(
                0,
                calculadora.calcular(0, 10)
        );
    }

    @Test
    void calcularValorCompraUmPercentualDezRetornaZeroVirgulaNove() {
        assertEquals(
                0.9,
                calculadora.calcular(1, 10)
        );
    }

    // ===== PERCENTUAL LIMITE INFERIOR =====

    @Test
    void calcularPercentualMenosCincoLancaIllegalArgumentException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.calcular(100, -5)
        );
    }

    @Test
    void calcularPercentualMenosUmLancaIllegalArgumentException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.calcular(100, -1)
        );
    }

    @Test
    void calcularPercentualZeroRetornaValorIntegral() {
        assertEquals(
                100,
                calculadora.calcular(100, 0)
        );
    }

    @Test
    void calcularPercentualUmRetornaNoventaENove() {
        assertEquals(
                99,
                calculadora.calcular(100, 1)
        );
    }

    // ===== PERCENTUAL LIMITE SUPERIOR =====

    @Test
    void calcularPercentualNoventaENoveRetornaUm() {
        assertEquals(
                1,
                calculadora.calcular(100, 99)
        );
    }

    @Test
    void calcularPercentualCemRetornaZero() {
        assertEquals(
                0,
                calculadora.calcular(100, 100)
        );
    }

    @Test
    void calcularPercentualCentoEUmLancaIllegalArgumentException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.calcular(100, 101)
        );
    }
}