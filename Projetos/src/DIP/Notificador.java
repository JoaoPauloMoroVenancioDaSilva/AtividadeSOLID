package DIP;

public interface Notificador {

    void enviar(String destinatario, String mensagem);

    String getCanal();
}
