package LSP;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {

    private final List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void listarDisponiveis() {
        System.out.println("=== CARDÁPIO - Itens Disponíveis ===");
        produtos.stream()
                .filter(Produto::isDisponivel)
                .forEach(p -> {
                    System.out.println("-".repeat(40));
                    p.exibir();
                });
        System.out.println("=".repeat(40));
    }

    public double calcularTotalCardapio() {
        return produtos.stream()
                .filter(Produto::isDisponivel)
                .mapToDouble(Produto::getPreco)
                .sum();
    }
}
