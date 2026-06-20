package com.tecsup.minishop.service;

import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    public boolean validarMonto(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto del pedido debe ser mayor a cero");
        }
        return true;
    }
}