package bd;

import product.Product;

import java.util.ArrayList;
import java.util.List;


public class BDProduct {// здесь хранятся все товары в наличии
    static int limitProduct = 1000; //используем правило Magic

    private static List<Product> productList = new ArrayList<>();

    public static List<Product> getProductList() {
        return productList;
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


