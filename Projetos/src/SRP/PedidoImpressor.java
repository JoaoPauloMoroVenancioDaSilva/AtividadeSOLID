package SRP;

public class PedidoImpressor {

    public void imprimirPedido(Pedido pedido) {
        System.out.println("=".repeat(45));
        System.out.println("Pedido: #" + pedido.getCodigo());
        System.out.println("=".repeat(45));
        System.out.println("Cliente: " + pedido.getNomeCliente());
        System.out.println("-".repeat(41));
        System.out.println(" ITENS: ");
        pedido.getItens().forEach(item ->
                System.out.printf("    %-20s x%d R$ %.2f%n",
                        item.getNome(),
                        item.getQuantidade(),
                        item.getPreco() * item.getQuantidade())
        );
        System.out.println("-".repeat(41));
        System.out.printf("Total = R$ %.2f%n", pedido.getValorTotal());
        System.out.println("=".repeat(45));

    }

}