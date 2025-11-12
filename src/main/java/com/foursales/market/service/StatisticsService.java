package com.foursales.market.service;

import com.foursales.market.dto.user.MonthlyRevenueDTO;
import com.foursales.market.dto.user.TopUserDTO;
import com.foursales.market.dto.user.UserTicketDTO;
import com.foursales.market.repository.OrderRepository;
import com.foursales.market.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatisticsService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public StatisticsService(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    public List<TopUserDTO> getTop5Users() {
        List<TopUserDTO> projections = userRepository.findTopUsersByTotalSpent();

        return projections.stream()
                .map(p -> new TopUserDTO(p.username(), p.totalSpent()))
                .collect(Collectors.toList());
    }

    public List<UserTicketDTO> getAllUsersAverageTicket() {
        List<UserTicketDTO> projections = userRepository.findAllUsersAverageTicket();

        return projections.stream()
                .map(p -> new UserTicketDTO(p.username(), p.averageTicket()))
                .collect(Collectors.toList());
    }

    public MonthlyRevenueDTO getMonthlyRevenue() {
        BigDecimal revenue = orderRepository.findTotalRevenueForCurrentMonth();
        return new MonthlyRevenueDTO(revenue != null ? revenue : BigDecimal.ZERO);
    }

}
