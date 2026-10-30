package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContaBancariaTest {

    // ===== CONSTRUTOR =====

    @Test
    void deveCriarContaComSaldoPositivo() {
        ContaBancaria conta = new ContaBancaria(5);

        assertEquals(5, conta.getSaldo());
    }

    @Test
    void deveCriarContaComSaldoZero() {
        ContaBancaria conta = new ContaBancaria(0);

        assertEquals(0, conta.getSaldo());
    }

    @Test
    void deveLancarExcecaoParaSaldoInicialLimiteInferior() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new ContaBancaria(-1)
        );
    }

    @Test
    void deveLancarExcecaoParaSaldoInicialNegativo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new ContaBancaria(-5)
        );
    }

    // ===== DEPÓSITO =====

    @Test
    void deveDepositarValorPositivo() {
        ContaBancaria conta = new ContaBancaria(10);

        conta.depositar(5);

        assertEquals(15, conta.getSaldo());
    }

    @Test
    void deveLancarExcecaoAoDepositarZero() {
        ContaBancaria conta = new ContaBancaria(10);

        assertThrows(
                IllegalArgumentException.class,
                () -> conta.depositar(0)
        );
    }

    @Test
    void deveLancarExcecaoAoDepositarMenosUm() {
        ContaBancaria conta = new ContaBancaria(10);

        assertThrows(
                IllegalArgumentException.class,
                () -> conta.depositar(-1)
        );
    }

    @Test
    void deveLancarExcecaoAoDepositarMenosCinco() {
        ContaBancaria conta = new ContaBancaria(10);

        assertThrows(
                IllegalArgumentException.class,
                () -> conta.depositar(-5)
        );
    }

    // ===== SAQUE =====

    @Test
    void deveSacarValorPositivo() {
        ContaBancaria conta = new ContaBancaria(10);

        conta.sacar(5);

        assertEquals(5, conta.getSaldo());
    }

    @Test
    void deveLancarExcecaoAoSacarZero() {
        ContaBancaria conta = new ContaBancaria(10);

        assertThrows(
                IllegalArgumentException.class,
                () -> conta.sacar(0)
        );
    }

    @Test
    void deveLancarExcecaoAoSacarMenosUm() {
        ContaBancaria conta = new ContaBancaria(10);

        assertThrows(
                IllegalArgumentException.class,
                () -> conta.sacar(-1)
        );
    }

    @Test
    void deveLancarExcecaoAoSacarMenosCinco() {
        ContaBancaria conta = new ContaBancaria(10);

        assertThrows(
                IllegalArgumentException.class,
                () -> conta.sacar(-5)
        );
    }

    @Test
    void deveLancarExcecaoQuandoSaldoForInsuficiente() {
        ContaBancaria conta = new ContaBancaria(10);

        assertThrows(
                IllegalArgumentException.class,
                () -> conta.sacar(15)
        );
    }
}