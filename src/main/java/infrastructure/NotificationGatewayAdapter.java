package infrastructure;

import application.NotificationGateway;

public class NotificationGatewayAdapter implements NotificationGateway {

    @Override
    public void trimiteNotificare(String destinatar, String mesaj) {
        // Implementare simplă (mock)
        System.out.printf("Notificare trimisa catre %s: %s%n", destinatar, mesaj);
    }
}