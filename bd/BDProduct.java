package bd;

import product.Food;
import product.Product;
import product.Smartfon;

import java.util.ArrayList;
import java.util.List;


public class BDProduct {// здесь хранятся все товары в наличии
    static int limitProduct = 1000; //используем правило Magic

    private static List<Product> productList = new ArrayList<>();

    public static List<Product> getProductList() {
        return productList;
    }
    public static void init(){
        add(new Food("Хлеб", 25.82, 250));
        add(new Food("Масло сливочное", 105.20, 50));
        add(new Food("Сметана 300г", 89.45, 89));
        add(new Food("Семечки", 41.20, 200));
        add(new Food("Молоко", 75.20, 400));
        add(new Food("Творог", 80.28, 100));
        add(new Food("Кефир", 45.20, 400));
        add(new Food("Яблоки", 85.00, 20));
        add(new Smartfon("Sony", 124.00, 12));

    }

    public static void add(Product product) {
        if (productList.size() <= limitProduct) {
            productList.add(product);
        } else System.out.println("Добавить продукт в прайс невозможно, превышен лимит");
    }

    public static Product searchProduct(int num) {
        for (Product product : productList) {
            if (product.getIdProduct() == num) return product;
        }
        return null;
    }

    public static void purchaseQuantity(int id, int quantity) {//уменьшение товара при покупке
        for (Product product : productList) {
            if (product.getIdProduct() == id) {
                product.setQuantity(product.getQuantity() - quantity);
            }
        }
    }
}


