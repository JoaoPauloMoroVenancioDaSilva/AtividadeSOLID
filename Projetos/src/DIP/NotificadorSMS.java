package DIP;

public class NotificadorSMS implements Notificador{

    private final String provedorSms;

    public NotificadorSMS(String provedorSms) {
        this.provedorSms = provedorSms;
    }

    @Override
    public void enviar(String destinatario, String mensagem) {
        String mensagemFinal = mensagem.length() > 160
            ? mensagem.substring(0, 157) + "..."
            :mensagem;
        System.out.printf("[SMS | Provedor: %s] Enviando para %s: \"%s\"\n",
                provedorSms, destinatario, mensagemFinal);
        System.out.println("[SMS] Mensagem enviada.");;
    }

    @Override
    public String getCanal() {
        return "SMS";
    }
}
