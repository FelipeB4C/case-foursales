package com.foursales.market.repository;

import com.foursales.market.model.Order;
import com.foursales.market.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    List<Order> findByConsumer(User consumer);

    @Query(value = """
        SELECT SUM(o.total_value) as totalRevenue
        FROM orders o
        WHERE o.status = 'APROVADO'
        AND MONTH(o.created_at) = MONTH(CURRENT_DATE())
        AND YEAR(o.created_at) = YEAR(CURRENT_DATE())
    """, nativeQuery = true)
    BigDecimal findTotalRevenueForCurrentMonth();

}
