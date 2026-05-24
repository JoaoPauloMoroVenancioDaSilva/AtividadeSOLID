package DIP;

public class NotificadorWhatsapp implements Notificador{

    private final String apiToken;

    public NotificadorWhatsapp(String apiToken) {
        this.apiToken = apiToken;
    }

    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.printf("[Whatsapp | Token: %s...] Enviando para %s: \"%s \"%n",
                apiToken.substring(0, Math.min(6, apiToken.length())), destinatario, mensagem);
        System.out.println("[Whatsapp] Mensagem entregue ✓");
    }

    @Override
    public String getCanal() {
        return "Whatsapp";
    }
}
