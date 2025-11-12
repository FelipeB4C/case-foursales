package com.foursales.market.controller;

import com.foursales.market.dto.user.MonthlyRevenueDTO;
import com.foursales.market.dto.user.TopUserDTO;
import com.foursales.market.dto.user.UserTicketDTO;
import com.foursales.market.service.StatisticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/top-users")
    public ResponseEntity<List<TopUserDTO>> getTopUsers() {
        return ResponseEntity.ok(statisticsService.getTop5Users());
    }

    @GetMapping("/user-aov")
    public ResponseEntity<List<UserTicketDTO>> getUserAOV() {
        return ResponseEntity.ok(statisticsService.getAllUsersAverageTicket());
    }

    @GetMapping("/monthly-revenue")
    public ResponseEntity<MonthlyRevenueDTO> getMonthlyRevenue() {
        return ResponseEntity.ok(statisticsService.getMonthlyRevenue());
    }
}
