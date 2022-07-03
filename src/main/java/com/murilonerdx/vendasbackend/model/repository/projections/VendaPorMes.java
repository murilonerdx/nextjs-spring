package com.murilonerdx.vendasbackend.model.repository.projections;

import java.math.BigDecimal;

public interface VendaPorMes {
    Integer getMes();
    BigDecimal getValor();
}