package application;

import domain.payment.PaymentType;
import domain.payment.Plata;

import java.math.BigDecimal;

public class PlataApplicationService {

    private final PlataFactory plataFactory;
    private final PaymentGateway paymentGateway;

    public PlataApplicationService(PlataFactory plataFactory,
                                   PaymentGateway paymentGateway) {
        this.plataFactory = plataFactory;
        this.paymentGateway = paymentGateway;
    }

    public Plata initiazaPlata(int idContract,
                               int idRata,
                               BigDecimal suma,
                               PaymentType tip) {

        // 1. Cream obiectul Plata folosind FACTORY METHOD
        Plata plata = plataFactory.createPlata(idContract, idRata, tip, suma);

        // 2. Trimitem plata la procesator prin ADAPTER
        boolean succes = paymentGateway.proceseazaPlata(plata);

        if (succes) {
            plata.marcheazaConfirmata();
        } else {
            plata.marcheazaRespinsa();
        }

        // aici, in viitor, vei apela repository, servicii de domeniu etc.
        return plata;
    }
}
