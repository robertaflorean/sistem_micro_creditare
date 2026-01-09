package org.example;

import application.NotificationGateway;
import application.PlataApplicationService;
import application.PlataFactory;
import application.PaymentGateway;
import domain.payment.PaymentType;
import domain.payment.Plata;
import infrastructure.PaymentGatewayAdapter;
import infrastructure.NotificationGatewayAdapter;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        // 1. Cream dependintele (Factory, Gateways)
        PlataFactory plataFactory = new PlataFactory();
        PaymentGateway paymentGateway = new PaymentGatewayAdapter();
        NotificationGateway notificationGateway = new NotificationGatewayAdapter();

        // 2. Cream serviciul de aplicatie pentru plati
        PlataApplicationService plataApplicationService =
                new PlataApplicationService(plataFactory, paymentGateway, notificationGateway);

        // 3. Simulam o plata pentru contractul 101, rata 3
        int idContract = 101;
        int idRata = 3;
        BigDecimal suma = new BigDecimal("500.00");
        PaymentType tipPlata = PaymentType.ONLINE;      // sau cum ai definit enum-ul
        String emailClient = "client@test.ro";

        Plata plata = plataApplicationService.initiazaPlata(
                idContract,
                idRata,
                suma,
                tipPlata,
                emailClient
        );

        // 4. Afisam rezultatul
        System.out.println("Plata rezultata:");
        System.out.println("  idPlata = " + plata.getIdPlata());
        System.out.println("  contract = " + plata.getIdContract());
        System.out.println("  rata = " + plata.getIdRata());
        System.out.println("  suma = " + plata.getSuma());
        System.out.println("  tip = " + plata.getTip());
    }
}
