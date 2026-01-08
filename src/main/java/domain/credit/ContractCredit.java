package domain.credit;

import domain.payment.PenaltyStrategy;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContractCredit {

    private int idContract;
    private BigDecimal soldRestant;
    private LocalDate dataScadentaCurenta;
    private String stareContract; // Activ, Restanta etc.

    public ContractCredit(int idContract,
                          BigDecimal soldRestant,
                          LocalDate dataScadentaCurenta,
                          String stareContract) {
        this.idContract = idContract;
        this.soldRestant = soldRestant;
        this.dataScadentaCurenta = dataScadentaCurenta;
        this.stareContract = stareContract;
    }

    public BigDecimal calculeazaPenalitateCurenta(PenaltyStrategy strategy, LocalDate azi) {
        return strategy.calculeazaPenalitate(soldRestant, dataScadentaCurenta, azi);
    }

    // getter/setter dupa nevoie
}
