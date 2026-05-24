package ISP;


// Interface 1: responsabilidade de envio de notificações
interface Notificavel {
    void enviarNotificacao(String destinatario, String mensagem);
}

// Interface 2: responsabilidade de geração de relatórios
interface Reportavel {
    void gerarRelatorio(String periodo);
    void exportarRelatorio(String formato);
}

// Interface 3: responsabilidade de gerenciamento de pedidos
interface GerenciadorPedidos {
    void criarPedido(String clienteId, String[] itens);
    void cancelarPedido(String pedidoId);
    String consultarStatusPedido(String pedidoId);
}

// Interface 4: responsabilidade de gerenciamento de entregas
interface GerenciadorEntregas {
    void designarEntregador(String pedidoId, String entregadorId);
    void atualizarLocalizacao(String pedidoId, String localizacao);
    String consultarPrevisaoEntrega(String pedidoId);
}

// Implementações — cada classe só implementa o que usa

class ServicoNotificacao implements Notificavel {

    @Override
    public void enviarNotificacao(String destinatario, String mensagem) {
        System.out.printf("[Notificação] Para: %s | Mensagem: %s%n", destinatario, mensagem);
    }
}


class ServicoRelatorio implements Reportavel {

    @Override
    public void gerarRelatorio(String periodo) {
        System.out.printf("[Relatório] Gerando relatório do período: %s%n", periodo);
    }

    @Override
    public void exportarRelatorio(String formato) {
        System.out.printf("[Relatório] Exportando como %s...%n", formato.toUpperCase());
    }
}


class ServicoPedido implements GerenciadorPedidos {

    @Override
    public void criarPedido(String clienteId, String[] itens) {
        System.out.printf("[Pedido] Criando pedido para cliente %s com %d item(s).%n",
                clienteId, itens.length);
    }

    @Override
    public void cancelarPedido(String pedidoId) {
        System.out.printf("[Pedido] Pedido #%s cancelado.%n", pedidoId);
    }

    @Override
    public String consultarStatusPedido(String pedidoId) {
        String status = "Em preparo";
        System.out.printf("[Pedido] Status do pedido #%s: %s%n", pedidoId, status);
        return status;
    }
}

class ServicoEntrega implements GerenciadorEntregas {

    @Override
    public void designarEntregador(String pedidoId, String entregadorId) {
        System.out.printf("[Entrega] Entregador %s designado ao pedido #%s.%n",
                entregadorId, pedidoId);
    }

    @Override
    public void atualizarLocalizacao(String pedidoId, String localizacao) {
        System.out.printf("[Entrega] Pedido #%s em: %s%n", pedidoId, localizacao);
    }

    @Override
    public String consultarPrevisaoEntrega(String pedidoId) {
        String previsao = "20-30 minutos";
        System.out.printf("[Entrega] Previsão do pedido #%s: %s%n", pedidoId, previsao);
        return previsao;
    }
}

class CentralPedidos implements GerenciadorPedidos, Notificavel {

    private final ServicoPedido servicoPedido = new ServicoPedido();
    private final ServicoNotificacao servicoNotificacao = new ServicoNotificacao();

    @Override
    public void criarPedido(String clienteId, String[] itens) {
        servicoPedido.criarPedido(clienteId, itens);
        enviarNotificacao(clienteId, "Seu pedido foi recebido e está sendo preparado!");
    }

    @Override
    public void cancelarPedido(String pedidoId) {
        servicoPedido.cancelarPedido(pedidoId);
        enviarNotificacao(pedidoId, "Seu pedido foi cancelado.");
    }

    @Override
    public String consultarStatusPedido(String pedidoId) {
        return servicoPedido.consultarStatusPedido(pedidoId);
    }

    @Override
    public void enviarNotificacao(String destinatario, String mensagem) {
        servicoNotificacao.enviarNotificacao(destinatario, mensagem);
    }
}

public class ISPDemo {

    public static void executar() {
        System.out.println("\n--- ISP: Interface Segregation Principle ---");

        ServicoNotificacao notificacao = new ServicoNotificacao();
        notificacao.enviarNotificacao("cliente@email.com", "Promoção disponível!");

        ServicoRelatorio relatorio = new ServicoRelatorio();
        relatorio.gerarRelatorio("Maio/2025");
        relatorio.exportarRelatorio("PDF");

        ServicoEntrega entrega = new ServicoEntrega();
        entrega.designarEntregador("P001", "João");
        entrega.atualizarLocalizacao("P001", "Rua das Flores, 200");
        entrega.consultarPrevisaoEntrega("P001");

        CentralPedidos central = new CentralPedidos();
        central.criarPedido("C42", new String[]{"Pizza", "Refrigerante"});
        central.consultarStatusPedido("P001");
    }
}
