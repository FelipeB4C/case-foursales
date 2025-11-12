package com.foursales.market.exception;

import java.time.LocalDateTime;
import java.util.List;

public record ApiValidationErrorDTO(
        LocalDateTime timestamp,
        Integer status,
        String error,
        List<String> messages,
        String path
) {}
