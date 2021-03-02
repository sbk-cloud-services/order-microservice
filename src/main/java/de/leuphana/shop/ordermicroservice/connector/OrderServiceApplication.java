package de.leuphana.shop.ordermicroservice.connector;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class OrderServiceApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext-jpa-connector.xml");
        OrderDatabaseConnector orderDatabaseConnector = (OrderDatabaseConnector) applicationContext.getBean("orderDatabaseConnector");
        OrderServiceImplementation.getInstance().setOrderDatabaseConnector(orderDatabaseConnector);
    }
}