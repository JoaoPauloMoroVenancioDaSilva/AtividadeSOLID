import SRP.Pedido;
import SRP.ItemPedido;
import SRP.PedidoRepositorio;
import SRP.PedidoImpressor;

import OCP.FormaPagamento;
import OCP.PagamentoCartao;
import OCP.PagamentoPix;
import OCP.PagamentoDinheiro;
import OCP.ProcessadorPagamento;

import LSP.Produto;
import LSP.Pizza;
import LSP.Hamburger;
import LSP.Bebida;
import LSP.Cardapio;

import ISP.ISPDemo;

import DIP.Notificador;
import DIP.NotificadorEmail;
import DIP.NotificadorSMS;
import DIP.NotificadorWhatsapp;
import DIP.SistemaNotificacao;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // 1. SRP — Single Responsibility Principle
        System.out.println("=".repeat(50));
        System.out.println("  1. SRP — Single Responsibility Principle");
        System.out.println("=".repeat(50));

        // Pedido só guarda dados
        Pedido pedido = new Pedido(1, "Carlos Mendes", Arrays.asList(
                new ItemPedido("Pizza Calabresa G", 52.90, 1),
                new ItemPedido("Coca-Cola 600ml",    8.50, 2),
                new ItemPedido("Brownie",            15.00, 1)
        ));

        // PedidoRepositorio só salva
        PedidoRepositorio repositorio = new PedidoRepositorio();
        repositorio.salvarPedido(pedido);

        // PedidoImpressor só exibe
        PedidoImpressor impressor = new PedidoImpressor();
        impressor.imprimirPedido(pedido);

        // 2. OCP — Open/Closed Principle
        System.out.println("\n" + "=".repeat(50));
        System.out.println("  2. OCP — Open/Closed Principle");
        System.out.println("=".repeat(50));

        ProcessadorPagamento processador = new ProcessadorPagamento();

        FormaPagamento cartao   = new PagamentoCartao("1234567890121111", "Visa");
        FormaPagamento pix      = new PagamentoPix("carlos@email.com");
        FormaPagamento dinheiro = new PagamentoDinheiro(100.00);

        processador.processarPagamento(cartao, 84.90);
        System.out.println();
        processador.processarPagamento(pix, 84.90);
        System.out.println();
        processador.processarPagamento(dinheiro, 84.90);

        // 3. LSP — Liskov Substitution Principle
        System.out.println("\n" + "=".repeat(50));
        System.out.println("  3. LSP — Liskov Substitution Principle");
        System.out.println("=".repeat(50));

        Cardapio cardapio = new Cardapio();

        cardapio.adicionarProduto(new Pizza("Pizza Quatro Queijos", 58.90, "Grande",
                new String[]{"Azeitona", "Tomate"}));

        cardapio.adicionarProduto(new Pizza("Pizza Frango c/ Catupiry", 62.00, "Média",
                new String[]{}));

        cardapio.adicionarProduto(new Hamburger("Smash Burger Clássico", 39.90,
                "Brioche", 180, "Fritas"));

        cardapio.adicionarProduto(new Hamburger("Veggie Burger", 36.50,
                "Integral", 160, "Salada"));

        Bebida suco    = new Bebida("Suco de Laranja", 12.00, 400, false);
        Bebida guarana = new Bebida("Guaraná Antárctica", 7.50, 350, true);
        guarana.setDisponivel(false); // simula item em falta

        cardapio.adicionarProduto(suco);
        cardapio.adicionarProduto(guarana);

        cardapio.listarDisponiveis();


        // 4. ISP — Interface Segregation Principle
        System.out.println("\n" + "=".repeat(50));
        System.out.println("  4. ISP — Interface Segregation Principle");
        System.out.println("=".repeat(50));

        ISPDemo.executar();

        // 5. DIP — Dependency Inversion Principle
        System.out.println("\n" + "=".repeat(50));
        System.out.println("  5. DIP — Dependency Inversion Principle");
        System.out.println("=".repeat(50));

        SistemaNotificacao sistema = new SistemaNotificacao();

        sistema.adicionarCanal(new NotificadorEmail("smtp.restaurante.com.br"));
        sistema.adicionarCanal(new NotificadorSMS("TotalVoice"));
        sistema.adicionarCanal(new NotificadorWhatsapp("Bearer_abc123xyz"));

        sistema.notificarTodos("Carlos Mendes", "Seu pedido #1 saiu para entrega!");

        System.out.println();
        sistema.notificarPorCanal("SMS", "+5543999990000", "Seu pedido chega em 15 min!");

        System.out.println("\n" + "=".repeat(50));
        System.out.println("  Todos os princípios SOLID demonstrados!");
        System.out.println("=".repeat(50));
    }
}