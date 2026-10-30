package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReservaHotelTest {

    // ===== NUMERO DE DIARIAS =====

    @Test
    void criarReservaNumeroDiariasMenosCincoLancaIllegalArgumentException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new ReservaHotel(-5, 100)
        );
    }

    @Test
    void criarReservaNumeroDiariasMenosUmLancaIllegalArgumentException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new ReservaHotel(-1, 100)
        );
    }

    @Test
    void criarReservaNumeroDiariasZeroLancaIllegalArgumentException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new ReservaHotel(0, 100)
        );
    }

    @Test
    void criarReservaNumeroDiariasUmRetornaReservaValida() {
        ReservaHotel reserva = new ReservaHotel(1, 100);

        assertFalse(reserva.isCancelada());
    }

    // ===== VALOR DIARIA =====

    @Test
    void criarReservaValorDiariaMenosCinquentaLancaIllegalArgumentException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new ReservaHotel(1, -50)
        );
    }

    @Test
    void criarReservaValorDiariaMenosUmLancaIllegalArgumentException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new ReservaHotel(1, -1)
        );
    }

    @Test
    void criarReservaValorDiariaZeroLancaIllegalArgumentException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new ReservaHotel(1, 0)
        );
    }

    @Test
    void criarReservaValorDiariaUmRetornaReservaValida() {
        ReservaHotel reserva = new ReservaHotel(1, 1);

        assertFalse(reserva.isCancelada());
    }

    // ===== DESCONTO =====

    @Test
    void calcularValorTotalSeisDiariasSemDescontoRetornaSeiscentos() {
        ReservaHotel reserva = new ReservaHotel(6, 100);

        assertEquals(600, reserva.calcularValorTotal());
    }

    @Test
    void calcularValorTotalSeteDiariasComDescontoRetornaSeiscentosETrinta() {
        ReservaHotel reserva = new ReservaHotel(7, 100);

        assertEquals(630, reserva.calcularValorTotal());
    }

    @Test
    void calcularValorTotalOitoDiariasComDescontoRetornaSetecentosEVinte() {
        ReservaHotel reserva = new ReservaHotel(8, 100);

        assertEquals(720, reserva.calcularValorTotal());
    }

    // ====TESTES EXTRAS =====
    @Test
    void adicionarCafeDaManhaUmaDiariaRetornaValorTotalTrintaEUm() {
        ReservaHotel reserva = new ReservaHotel(1, 1);

        reserva.adicionarCafeDaManha();

        assertEquals(31, reserva.calcularValorTotal());
    }

    @Test
    void cancelarReservaRetornaValorTotalZero() {
        ReservaHotel reserva = new ReservaHotel(5, 100);

        reserva.cancelar();

        assertEquals(0, reserva.calcularValorTotal());
    }

    @Test
    void cancelarReservaDuasVezesLancaIllegalStateException() {
        ReservaHotel reserva = new ReservaHotel(5, 100);

        reserva.cancelar();

        assertThrows(
                IllegalStateException.class,
                reserva::cancelar
        );
    }

    @Test
    void adicionarCafeDaManhaEmReservaCanceladaLancaIllegalStateException() {
        ReservaHotel reserva = new ReservaHotel(5, 100);

        reserva.cancelar();

        assertThrows(
                IllegalStateException.class,
                reserva::adicionarCafeDaManha
        );
    }
}