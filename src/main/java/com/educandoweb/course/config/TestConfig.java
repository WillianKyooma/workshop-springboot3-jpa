package com.educandoweb.course.config;

import java.sql.Array;
import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

@Autowired	
private UserRepository userRepository;

@Autowired
private OrderRepository orderRepository;
@Override
public void run(String... args) throws Exception {
    User u1 = new User("Maria", "Maria@gmail.com", "98888", "12345");
    User u2 = new User("Alex", "Alex@gmail.com", "97777", "12345");
    
    
    
   
    Order o1 = new Order(0L, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID,u1);
    Order o2 = new Order(0L, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAYTING_PAYMENT, u2);
    Order o3 = new Order(0L, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAYTING_PAYMENT, u1);
    


    userRepository.saveAll(Arrays.asList(u1, u2));
    orderRepository.saveAll(Arrays.asList(o1, o2, o3));

}


}
