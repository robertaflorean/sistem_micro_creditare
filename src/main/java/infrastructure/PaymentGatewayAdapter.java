package infrastructure;

import application.PaymentGateway;
import domain.payment.Plata;


public class PaymentGatewayAdapter implements PaymentGateway {

    @Override
    public boolean proceseazaPlata(Plata plata) {
        // Aici ar fi apelul real catre un API extern (REST/SOAP etc.)
        // Pentru proiectul de laborator e suficient un "simulated call"

        System.out.println("Trimit plata catre procesator extern: " + plata);
        // simulam un raspuns pozitiv
        return true;
    }
}
