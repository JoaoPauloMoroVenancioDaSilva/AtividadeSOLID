package OCP;

public class PagamentoPix extends FormaPagamento{

    private final String chavePix;

    public PagamentoPix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public void pagar(double valor) {
        System.out.printf("[PIX] Transferindo R$ %.2f para a chave: %s%n", valor, chavePix);
        System.out.printf("[PIX] Pagamento confirmado instantaneamente.");
    }

    @Override
    public String getDescricao() {
        return "PIX (" + chavePix + ")";
    }
}
