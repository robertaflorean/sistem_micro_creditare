package domain.payment;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class StandardPenaltyStrategy implements PenaltyStrategy {

    private static final BigDecimal ZIUA_PROCENT = new BigDecimal("0.001"); // 0.1% / zi

    @Override
    public BigDecimal calculeazaPenalitate(BigDecimal soldRestant,
                                           LocalDate dataScadenta,
                                           LocalDate dataCurenta) {
        if (dataCurenta.isBefore(dataScadenta) || soldRestant.compareTo(BigDecimal.ZERO) <= 0) {
            return BigDecimal.ZERO;
        }
        long zileIntarziere = ChronoUnit.DAYS.between(dataScadenta, dataCurenta);
        return soldRestant
                .multiply(ZIUA_PROCENT)
                .multiply(BigDecimal.valueOf(zileIntarziere));
    }
}
