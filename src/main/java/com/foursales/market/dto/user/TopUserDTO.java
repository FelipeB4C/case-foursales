package com.foursales.market.dto.user;

import java.math.BigDecimal;

public record TopUserDTO(
        String username,
        BigDecimal totalSpent
) {}
