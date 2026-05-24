package SRP;

import java.util.ArrayList;
import java.util.List;

public class PedidoRepositorio {

    private final List<Pedido> pedidos = new ArrayList<>();

    public void salvarPedido(Pedido pedido) {
        pedidos.add(pedido);
        System.out.println("Pedido #" + pedido.getCodigo() + " salvo com sucesso!");
    }

}