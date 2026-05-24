package OCP;

public class PagamentoCartao extends FormaPagamento{

    private final String numeroCartao;
    private final String bandeira;

    public PagamentoCartao(String numeroCartao, String bandeira){
        this.numeroCartao = numeroCartao;
        this.bandeira = bandeira;
    }

    @Override
    public void pagar(double valor) {
        String cartaoMascarado = "**** **** **** " + numeroCartao.
                substring(numeroCartao.length() - 4);
        System.out.printf("[CARTÃO: %s] cobrando R$ %.2f%n", cartaoMascarado, valor);
    }

    @Override
    public String getDescricao() {
        return "Cartão " + bandeira;
    }
}
