package org.xander;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class ECommerceDemo {
    public static void main(String[] args) {
        // Ініціалізація платформи
        ECommercePlatform platform = new ECommercePlatform();

        // Додавання користувачів та товарів
        User user1 = new User(1, "user1");
        User user2 = new User(2, "user2");
        platform.addUser(user1);
        platform.addUser(user2);

        Product product1 = new Product(1, "Product A", 20.0, 50);
        Product product2 = new Product(2, "Product B", 15.0, 30);
        platform.addProduct(product1);
        platform.addProduct(product2);

        // Симулювання взаємодії користувачів з кошиком
        user1.addToCart(product1, 2);
        user1.addToCart(product2, 3);

        user2.addToCart(product1, 1);
        user2.addToCart(product2, 2);

        // Симулювання створення та обробки замовлень
        platform.createOrder(user1.getId(), user1.getCart());
        platform.createOrder(user2.getId(), user2.getCart());

        // Вивід стану користувачів, товарів та замовлень
        System.out.println("Users:");
        platform.listUsers().forEach(System.out::println);

        System.out.println("\nProducts:");
        platform.listAvailableProducts().forEach(System.out::println);

        System.out.println("\nOrders:");
        platform.listOrders().forEach(System.out::println);

        // Сортування та фільтрація
        System.out.println("\nSorted Products by Name:");
        List<Product> sortedByName = platform.listAvailableProducts()
                .stream()
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());
        sortedByName.forEach(System.out::println);

        System.out.println("\nSorted Products by Price:");
        List<Product> sortedByPrice = platform.listAvailableProducts()
                .stream()
                .sorted()
                .collect(Collectors.toList());
        sortedByPrice.forEach(System.out::println);

        System.out.println("\nSorted Products by Stock:");
        List<Product> sortedByStock = platform.listAvailableProducts()
                .stream()
                .sorted(Comparator.comparingInt(Product::getStock))
                .collect(Collectors.toList());
        sortedByStock.forEach(System.out::println);

        System.out.println("\nAvailable Products with Stock > 0:");
        List<Product> availableProducts = platform.listAvailableProducts()
                .stream()
                .filter(product -> product.getStock() > 0)
                .collect(Collectors.toList());
        availableProducts.forEach(System.out::println);
    }
}
