package DIP;

public class NotificadorEmail implements Notificador{

    private final String servidorSmtp;

    public NotificadorEmail(String servidorSmtp) {
        this.servidorSmtp = servidorSmtp;
    }

    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.printf("[E-mail | SMTP: %s] Enviando para %s: \"%s\"\n",
                servidorSmtp, destinatario, mensagem);
        System.out.printf("[E-mail] Mensagem entregue com sucesso.");
    }

    @Override
    public String getCanal() {
        return "E-mail";
    }
}
