package com.uestc.model;

import java.math.BigDecimal;

public interface BalanceMutator {
    BigDecimal mutate(BigDecimal balance);
}
