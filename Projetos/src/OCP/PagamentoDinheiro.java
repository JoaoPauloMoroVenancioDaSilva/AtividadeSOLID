package OCP;

public class PagamentoDinheiro extends FormaPagamento{

    private final double valorEntregue;

    public PagamentoDinheiro(double valorEntregue) {
        this.valorEntregue = valorEntregue;
    }

    @Override
    public void pagar(double valor) {
        double troco = valorEntregue - valor;
        System.out.printf("[DINHEIRO] Valor recebido: R$ %.2f | Valor do pedido: R$ %.2f%n", valorEntregue, valor);
        if (troco >= 0) {
            System.out.printf("[DINHEIRO] Troco: R$ %.2f%n", troco);
        } else {
            System.out.printf("[DINHEIRO] ATENÇÃO: valor insuficiente! Faltam R$ %.2f%n", Math.abs(troco));
        }
    }

    @Override
    public String getDescricao() {
        return "Dinheiro";
    }

}
