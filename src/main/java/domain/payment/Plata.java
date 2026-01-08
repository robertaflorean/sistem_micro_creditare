package domain.payment;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Plata {

    private int idPlata;              // poate rămâne 0 dacă nu ai persistenta
    private final int idContract;
    private final int idRata;
    private final PaymentType tip;
    private final BigDecimal suma;
    private final LocalDate dataPlata;
    private String statusPlata;       // INREGISTRATA / CONFIRMATA / RESPINSA
    private String canalPlata;        // Online / Transfer / Cash

    public Plata(int idContract,
                 int idRata,
                 PaymentType tip,
                 BigDecimal suma,
                 LocalDate dataPlata) {
        this.idContract = idContract;
        this.idRata = idRata;
        this.tip = tip;
        this.suma = suma;
        this.dataPlata = dataPlata;
        this.statusPlata = "INREGISTRATA";
        this.canalPlata = tip.name();
    }

    public void marcheazaConfirmata() {
        this.statusPlata = "CONFIRMATA";
    }

    public void marcheazaRespinsa() {
        this.statusPlata = "RESPINSA";
    }

    // getter-e dupa nevoie
}
