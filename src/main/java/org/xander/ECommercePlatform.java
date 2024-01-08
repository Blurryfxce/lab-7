package org.xander;

import java.util.*;

class ECommercePlatform {
    private Map<Integer, User> users;
    private Map<Integer, Product> products;
    private Map<Integer, Order> orders;

    public ECommercePlatform() {
        this.users = new HashMap<>();
        this.products = new HashMap<>();
        this.orders = new HashMap<>();
    }

    // Методи для додавання користувачів, товарів, створення замовлення, переліку доступних товарів,
    // переліку користувачів, переліку замовлень та оновлення запасів товарів.

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public void createOrder(Integer userId, Map<Product, Integer> orderDetails) {
        Order order = new Order(generateOrderId(), userId);
        order.setOrderDetails(orderDetails);
        order.calculateTotalPrice();
        orders.put(order.getId(), order);
    }

    public List<Product> listAvailableProducts() {
        return new ArrayList<>(products.values());
    }

    public List<User> listUsers() {
        return new ArrayList<>(users.values());
    }

    public List<Order> listOrders() {
        return new ArrayList<>(orders.values());
    }

    public void updateProductStock(Product product, int newStock) {
        product.setStock(newStock);
    }

    private int generateOrderId() {
        // Логіка для генерації унікального ідентифікатора для замовлення
        return orders.size() + 1;
    }
}

