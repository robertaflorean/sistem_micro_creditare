package domain.payment;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NoPenaltyStrategy implements PenaltyStrategy {

    @Override
    public BigDecimal calculeazaPenalitate(BigDecimal soldRestant,
                                           LocalDate dataScadenta,
                                           LocalDate dataCurenta) {
        return BigDecimal.ZERO;
    }
}
