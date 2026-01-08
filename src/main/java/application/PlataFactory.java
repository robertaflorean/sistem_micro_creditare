package application;

import domain.payment.PaymentType;
import domain.payment.Plata;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PlataFactory {

    public Plata createPlata(int idContract,
                             int idRata,
                             PaymentType tip,
                             BigDecimal suma) {

        LocalDate azi = LocalDate.now();

        // aici poți pune logica specifică fiecărui tip (comisioane, validări etc.)
        switch (tip) {
            case ONLINE:
                // eventual reguli speciale pentru online
                break;
            case TRANSFER:
                // reguli pentru transfer bancar
                break;
            case CASH:
                // reguli pentru cash
                break;
            default:
                throw new IllegalArgumentException("Tip de plata necunoscut: " + tip);
        }

        return new Plata(idContract, idRata, tip, suma, azi);
    }
}
