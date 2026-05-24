package DIP;

import java.util.ArrayList;
import java.util.List;

public class SistemaNotificacao {

    private final List<Notificador> notificadores = new ArrayList<>();

    public void adicionarCanal(Notificador notificador) {
        notificadores.add(notificador);
        System.out.println("[SistemaNotificacao] Canal registrado: " + notificador.getCanal());
    }

    public void notificarTodos(String destinatario, String mensagem) {
        System.out.printf("%n[SistemaNotificacao] Disparando notificação para '%s'...%n", destinatario);
        notificadores.forEach(n -> n.enviar(destinatario, mensagem));
        System.out.println("[SistemaNotificacao] Notificação enviada por " + notificadores.size() + " canal(is).");
    }


    public void notificarPorCanal(String canal, String destinatario, String mensagem) {
        notificadores.stream()
                .filter(n -> n.getCanal().equalsIgnoreCase(canal))
                .findFirst()
                .ifPresentOrElse(
                        n -> n.enviar(destinatario, mensagem),
                        () -> System.out.println("[Sistema Notificador] Canal '" + canal + "' não encontrado.")
                );
    }
}
