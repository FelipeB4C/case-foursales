package com.foursales.market.repository;

import com.foursales.market.dto.user.TopUserDTO;
import com.foursales.market.dto.user.UserTicketDTO;
import com.foursales.market.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User findByUsername(String username);

    @Query(value = """
        SELECT u.username AS username, SUM(o.total_value) AS totalSpent
                                                       FROM orders o
                                                       JOIN users u ON o.consumer_id = u.id
                                                       WHERE o.status = 'APROVADO'
                                                       GROUP BY u.id, u.username
                                                       ORDER BY totalSpent DESC
                                                       LIMIT 5
    """, nativeQuery = true)
    List<TopUserDTO> findTopUsersByTotalSpent();


    @Query(value = """
        SELECT u.username AS username, AVG(o.total_value) AS averageTicket
                        FROM orders o
                        JOIN users u ON o.consumer_id = u.id
                        WHERE o.status = 'APROVADO'
                        GROUP BY u.id, u.username
    """, nativeQuery = true)
    List<UserTicketDTO> findAllUsersAverageTicket();

}
