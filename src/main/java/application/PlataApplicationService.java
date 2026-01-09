package application;

import domain.payment.PaymentType;
import domain.payment.Plata;

import java.math.BigDecimal;

public class PlataApplicationService {

    private final PlataFactory plataFactory;
    private final PaymentGateway paymentGateway;
    private final NotificationGateway notificationGateway;

    public PlataApplicationService(PlataFactory plataFactory,
                                   PaymentGateway paymentGateway,
                                   NotificationGateway notificationGateway) {
        this.plataFactory = plataFactory;
        this.paymentGateway = paymentGateway;
        this.notificationGateway = notificationGateway;
    }

    public Plata initiazaPlata(int idContract,
                               int idRata,
                               BigDecimal suma,
                               PaymentType tip,
                               String destinatarNotificare) {

        // 1. Cream obiectul Plata folosind FACTORY METHOD
        Plata plata = plataFactory.createPlata(idContract, idRata, tip, suma);

        // 2. Trimitem plata la procesator prin ADAPTER
        boolean succes = paymentGateway.proceseazaPlata(plata);

        if (succes) {
            plata.marcheazaConfirmata();
            notificationGateway.trimiteNotificare(
                    destinatarNotificare,
                    "Plata pentru contractul " + idContract +
                            " si rata " + idRata + " a fost confirmata. Suma: " + suma
            );
        } else {
            plata.marcheazaRespinsa();
            notificationGateway.trimiteNotificare(
                    destinatarNotificare,
                    "Plata pentru contractul " + idContract +
                            " si rata " + idRata + " a fost respinsa."
            );
        }

        // aici, in viitor, vei apela repository, servicii de domeniu etc.
        return plata;
    }

}
