package com.confrariadev;

import jakarta.enterprise.context.ApplicationScoped;
import org.apache.camel.Header;

import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class PedidoService {

    private final Set<Long> pedidos = new HashSet<>();

    public void newPedido(@Header("id") Long id) {
        pedidos.add(id);
    }

    public void cancelPedido(@Header("id") Long id) {
        pedidos.remove(id);
    }

}
