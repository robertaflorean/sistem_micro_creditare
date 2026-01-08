package domain.payment;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface PenaltyStrategy {

    BigDecimal calculeazaPenalitate(
            BigDecimal soldRestant,
            LocalDate dataScadenta,
            LocalDate dataCurenta
    );
}

