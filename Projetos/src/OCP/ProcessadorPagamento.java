package OCP;

public class ProcessadorPagamento {

public void processarPagamento(FormaPagamento formaPagamento, double valor) {
    System.out.println("Processando pagamento via " + formaPagamento.getDescricao());
    formaPagamento.pagar(valor);
    System.out.println("Pagamento processado com sucesso!");
    }

}
