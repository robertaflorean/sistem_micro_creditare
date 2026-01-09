package domain.payment;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Plata {

    private int idPlata;              // poate rămâne 0 dacă nu ai persistență
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

    // === getter-e folosite în Main ===

    public int getIdPlata() {
        return idPlata;
    }

    public int getIdContract() {
        return idContract;
    }

    public int getIdRata() {
        return idRata;
    }

    public PaymentType getTip() {
        return tip;
    }

    public BigDecimal getSuma() {
        return suma;
    }

    public LocalDate getDataPlata() {
        return dataPlata;
    }

    public String getStatusPlata() {
        return statusPlata;
    }

    public String getCanalPlata() {
        return canalPlata;
    }
}
