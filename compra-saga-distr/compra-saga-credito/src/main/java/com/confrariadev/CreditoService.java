package com.confrariadev;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class CreditoService {

    private final Map<Long, Integer> pedido_valor = new HashMap<>();
    private int creditoTotal;

    public CreditoService() {
        this.creditoTotal = 100;
    }

    public void newPedidoValor(Long pedidoId, int valor) {
        if (valor > creditoTotal) {
            throw new IllegalStateException("saldo insuficiente");
        }

        creditoTotal = creditoTotal - valor;
        pedido_valor.put(pedidoId, valor);
    }

    public void cancelPedidoValor(Long id) {
        System.out.println("PedidoValor falhou. Iniciando cancelamento do pedido. Id: " + id);
    }

    public int getCreditoTotal() {
        return this.creditoTotal;
    }
}
