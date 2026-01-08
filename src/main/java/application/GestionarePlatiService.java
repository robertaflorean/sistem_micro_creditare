package application;

import domain.credit.ContractCredit;
import domain.payment.PenaltyStrategy;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GestionarePlatiService {

    private final PenaltyStrategy penaltyStrategy;

    public GestionarePlatiService(PenaltyStrategy penaltyStrategy) {
        this.penaltyStrategy = penaltyStrategy;
    }

    public BigDecimal calculeazaPenalitatiPentruContract(ContractCredit contract) {
        LocalDate azi = LocalDate.now();
        return contract.calculeazaPenalitateCurenta(penaltyStrategy, azi);
    }
}
