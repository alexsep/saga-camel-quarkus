package com.confrariadev;

import jakarta.enterprise.context.ApplicationScoped;
import org.apache.camel.Header;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class CreditoService {

    private final Map<Long, Integer> pedido_valor = new HashMap<>();
    private int creditoTotal;

    public CreditoService() {
        this.creditoTotal = 100;
    }

    public void newPedidoValor(@Header("id") Long pedidoId, @Header("valor") int valor) {
        if (valor > creditoTotal) {
            throw new IllegalStateException("saldo insuficiente");
        }

        creditoTotal = creditoTotal - valor;
        pedido_valor.put(pedidoId, valor);
    }

    public void cancelPedidoValor(@Header("id") Long id) {
        System.out.println("PedidoValor falhou. Iniciando cancelamento do pedido.");
//        creditoTotal = creditoTotal + pedido_valor.get(id);
//        pedido_valor.remove(id);
    }

    public int getCreditoTotal() {
        return this.creditoTotal;
    }
}
