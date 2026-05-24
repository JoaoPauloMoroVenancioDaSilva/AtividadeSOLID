package SRP;

import java.util.*;

public class Pedido {

    private int codigo;
    private String nomeCliente;
    private List<ItemPedido> itens;

    public Pedido(int codigo, String nomeCliente, List<ItemPedido> itens) {
        this.codigo = codigo;
        this.nomeCliente = nomeCliente;
        this.itens = itens;
    }

    public double getValorTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

}