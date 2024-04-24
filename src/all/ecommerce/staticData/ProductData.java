package all.ecommerce.staticData;

import all.ecommerce.model.Product;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ProductData {

    public static List<Product> getSampleProducts(Connection connection) {
        List<Product> productList = new ArrayList<>();

        productList.add(new Product(1, "Laptop", "Electronics", 999.99, "female-shoes.jpg"));
        productList.add(new Product(2, "Smartphone", "Electronics", 499.99, "ladis-bag.jpg"));
        productList.add(new Product(3, "Headphones", "Electronics", 79.99, "men-suits.jpg"));
        productList.add(new Product(4, "Coffee Maker", "Appliances", 39.99, "men-watch.jpg"));
        productList.add(new Product(5, "Backpack", "Fashion", 29.99, "ladis-bag.jpg"));
        productList.add(new Product(6, "Running Shoes", "Fashion", 89.99, "smoking-e-cigarette.jpg"));
        productList.add(new Product(7, "Bookshelf", "Furniture", 149.99, "smoking-e-cigarette-2.jpg"));
        productList.add(new Product(8, "Desk Chair", "Furniture", 79.99, "female-shoes.jpg"));

        return productList;
    }
}
