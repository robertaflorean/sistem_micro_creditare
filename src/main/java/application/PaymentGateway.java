package application;

import domain.payment.Plata;

public interface PaymentGateway {

    /**
     * Proceseaza plata in sistemul extern (banca / procesator).
     * @return true daca plata a fost acceptata, false altfel.
     */
    boolean proceseazaPlata(Plata plata);
}
