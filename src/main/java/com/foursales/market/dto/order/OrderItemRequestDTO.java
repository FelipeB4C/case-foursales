package com.foursales.market.dto.order;

import java.util.UUID;

public record OrderItemRequestDTO(
     UUID id,
     Integer quantity
){}
