package com.tecsup.minishop.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoServiceTest {

    private final PedidoService pedidoService = new PedidoService();

    @Test
    public void cuandoMontoEsValido_entoncesRetornaTrue() {
        boolean resultado = pedidoService.validarMonto(500.0);
        assertTrue(resultado);
    }

    @Test
    public void cuandoMontoEsMenorOSigualACero_entoncesLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            pedidoService.validarMonto(0.0);
        });
    }
}