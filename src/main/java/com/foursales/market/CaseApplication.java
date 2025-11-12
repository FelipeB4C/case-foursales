package com.foursales.market;

import com.foursales.market.Enum.OrderStatus;
import com.foursales.market.Enum.UserRole;
import com.foursales.market.model.Order;
import com.foursales.market.model.OrderItem;
import com.foursales.market.model.Product;
import com.foursales.market.model.User;
import com.foursales.market.repository.OrderRepository;
import com.foursales.market.repository.ProductRepository;
import com.foursales.market.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class CaseApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CaseApplication.class, args);
	}

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;


    public CaseApplication(UserRepository userRepository, ProductRepository productRepository,
                           OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {

            String adminEncodedPassword = "$2a$10$OD/Z3iB3ngRrgOLRdCZBgOo6ioULmXbrd01niQlw.CHiXVwsU7ks.";
            String userEncodedPassword = "$2a$10$YcupddIbnCvYtKV0mXUIEeQH13ynIUXMXRmhDTy/hDbnPxvW6zpEK";

            User admin = new User("admin.user", adminEncodedPassword, UserRole.ADMIN);
            User user1 = new User("normal.user", userEncodedPassword, UserRole.USER);
            User user2 = new User("ana.silva", userEncodedPassword, UserRole.USER);
            User user3 = new User("bruno.costa", userEncodedPassword, UserRole.USER);
            User user4 = new User("carla.dias", userEncodedPassword, UserRole.USER);
            User user5 = new User("diego.fernandes", userEncodedPassword, UserRole.USER);
            List<User> normalUsers = List.of(user1, user2, user3, user4, user5);

            userRepository.saveAll(List.of(admin, user1, user2, user3, user4, user5));


            List<Product> initialProducts = List.of(
                    new Product(
                            "Monitor Gamer 27'",
                            "Monitor de alta performance com 144Hz e painel IPS.",
                            new BigDecimal("1899.90"),
                            "MONITOR",
                            50
                    ),
                    new Product(
                            "Teclado Mecânico RGB",
                            "Switch Red, layout ABNT2, com iluminação customizável.",
                            new BigDecimal("450.00"),
                            "PERIFÉRICO",
                            120
                    ),
                    new Product(
                            "Mouse sem Fio",
                            "Design ergonômico, 16000 DPI, bateria de longa duração.",
                            new BigDecimal("215.50"),
                            "PERIFÉRICO",
                            85
                    ),
                    new Product(
                            "Headset Pro X",
                            "Áudio 7.1 surround, microfone com cancelamento de ruído.",
                            new BigDecimal("780.00"),
                            "PERIFÉRICO",
                            60
                    ),
                    new Product(
                            "Webcam Full HD",
                            "Lente de vidro, 1080p a 30fps, ideal para streaming.",
                            new BigDecimal("199.99"),
                            "PERIFÉRICO",
                            150
                    ),
                    new Product(
                            "Processador AMD 1800X",
                            "Processador AMD 8 núcleos",
                            new BigDecimal("899.99"),
                            "HARDWARE",
                            10
                    ),
                    new Product(
                            "Cadeira gamer",
                            "Cadeira gamer X PRO",
                            new BigDecimal("999.99"),
                            "CADEIRA",
                            5
                    )
            );

            List<Product> savedProducts = productRepository.saveAll(initialProducts);


            List<Order> ordersToSave = new ArrayList<>();


            Order order1 = new Order(normalUsers.get(0), OrderStatus.APROVADO);
            List<OrderItem> items1 = List.of(
                    new OrderItem(order1, savedProducts.get(0), 1, savedProducts.get(0).getPrice()),
                    new OrderItem(order1, savedProducts.get(2), 1, savedProducts.get(2).getPrice())
            );
            order1.setItems(items1);
            order1.setTotalValue(calculateTotal(items1));
            ordersToSave.add(order1);


            Order order2 = new Order(normalUsers.get(1), OrderStatus.PENDENTE);
            List<OrderItem> items2 = List.of(
                    new OrderItem(order2, savedProducts.get(6), 1, savedProducts.get(6).getPrice())
            );
            order2.setItems(items2);
            order2.setTotalValue(calculateTotal(items2));
            ordersToSave.add(order2);


            Order order3 = new Order(normalUsers.get(2), OrderStatus.APROVADO);
            List<OrderItem> items3 = List.of(
                    new OrderItem(order3, savedProducts.get(1), 1, savedProducts.get(1).getPrice()),
                    new OrderItem(order3, savedProducts.get(3), 1, savedProducts.get(3).getPrice())
            );
            order3.setItems(items3);
            order3.setTotalValue(calculateTotal(items3));
            ordersToSave.add(order3);

            Order order4 = new Order(normalUsers.get(3), OrderStatus.PENDENTE);
            List<OrderItem> items4 = List.of(
                    new OrderItem(order4, savedProducts.get(5), 2, savedProducts.get(5).getPrice())
            );
            order4.setItems(items4);
            order4.setTotalValue(calculateTotal(items4));
            ordersToSave.add(order4);


            Order order5 = new Order(normalUsers.get(4), OrderStatus.APROVADO);
            List<OrderItem> items5 = List.of(
                    new OrderItem(order5, savedProducts.get(4), 1, savedProducts.get(4).getPrice())
            );
            order5.setItems(items5);
            order5.setTotalValue(calculateTotal(items5));
            ordersToSave.add(order5);


            Order order6 = new Order(normalUsers.get(0), OrderStatus.PENDENTE);
            List<OrderItem> items6 = List.of(new OrderItem(order6, savedProducts.get(1), 1, savedProducts.get(1).getPrice()));
            order6.setItems(items6);
            order6.setTotalValue(calculateTotal(items6));
            ordersToSave.add(order6);


            Order order7 = new Order(normalUsers.get(1), OrderStatus.APROVADO);
            List<OrderItem> items7 = List.of(new OrderItem(order7, savedProducts.get(2), 2, savedProducts.get(2).getPrice()));
            order7.setItems(items7);
            order7.setTotalValue(calculateTotal(items7));
            ordersToSave.add(order7);


            Order order8 = new Order(normalUsers.get(2), OrderStatus.PENDENTE);
            List<OrderItem> items8 = List.of(new OrderItem(order8, savedProducts.get(0), 1, savedProducts.get(0).getPrice()));
            order8.setItems(items8);
            order8.setTotalValue(calculateTotal(items8));
            ordersToSave.add(order8);


            Order order9 = new Order(normalUsers.get(3), OrderStatus.APROVADO);
            List<OrderItem> items9 = List.of(
                    new OrderItem(order9, savedProducts.get(5), 1, savedProducts.get(5).getPrice()),
                    new OrderItem(order9, savedProducts.get(6), 1, savedProducts.get(6).getPrice())
            );
            order9.setItems(items9);
            order9.setTotalValue(calculateTotal(items9));
            ordersToSave.add(order9);

            Order order10 = new Order(normalUsers.get(4), OrderStatus.PENDENTE);
            List<OrderItem> items10 = List.of(new OrderItem(order10, savedProducts.get(3), 1, savedProducts.get(3).getPrice()));
            order10.setItems(items10);
            order10.setTotalValue(calculateTotal(items10));
            ordersToSave.add(order10);

            orderRepository.saveAll(ordersToSave);

            System.out.println(initialProducts.size() + " Produtos iniciais criados.");
        } else {
            System.out.println("Banco de dados já populado, pulando seeder.");
        }
    }
    private BigDecimal calculateTotal(List<OrderItem> items) {
        return items.stream()
                .map(item -> item.getPriceAtOrder().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
