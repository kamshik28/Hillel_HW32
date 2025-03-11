package org.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CoffeeOrderBoard {

    private static final Logger logger = LoggerFactory.getLogger(CoffeeOrderBoard.class);

    private final List<Order> orders;
    private int nextOrderNumber;

    public CoffeeOrderBoard() {
        this.orders = new LinkedList<>();
        this.nextOrderNumber = 1;
        logger.info("CoffeeOrderBoard створено. Початковий номер замовлення = 1");
    }


    public void add(String customerName) {
        if (customerName == null || customerName.trim().isEmpty()) {
            logger.error("Спроба додати замовлення з порожнім ім'ям");
            throw new IllegalArgumentException("Customer name cannot be null or empty");
        }
        Order newOrder = new Order(nextOrderNumber, customerName);
        orders.add(newOrder);
        logger.info("Додано замовлення: {}", newOrder);
        nextOrderNumber++;
    }

    public Order deliver() {
        if (orders.isEmpty()) {
            logger.warn("Спроба видати замовлення, але черга порожня!");
            return null;
        }
        Order order = orders.remove(0);
        logger.info("Видано замовлення (FIFO): {}", order);
        return order;
    }


    public Order deliver(int orderNumber) {
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order o = iterator.next();
            if (o.getOrderNumber() == orderNumber) {
                iterator.remove();
                logger.info("Видано замовлення з номером {}: {}", orderNumber, o);
                return o;
            }
        }
        logger.error("Спроба видати замовлення з номером {}, але його не знайдено!", orderNumber);
        return null;
    }


    public void draw() {
        logger.info("Вивід поточного стану черги замовлень:");
        System.out.println("Num | Name");
        for (Order o : orders) {
            System.out.println(o.getOrderNumber() + "   | " + o.getCustomerName());
        }
    }

    public int getOrderCount() {
        return orders.size();
    }
}
