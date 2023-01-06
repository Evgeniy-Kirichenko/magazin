package cart;

import bd.BDProduct;
import product.Product;
import user.User;

import java.util.ArrayList;
import java.util.List;

public class Cart {//корзина пользователя принцип Single Responsibility Principle делает только
    //действия с корзиной продуктов
    private List<Product> cartProduct; //Open Closed Principle
    private User user;


    public Cart(User user) {
        this.user = user;
        cartProduct = new ArrayList<>();
    }

    public void addCart(int num, int quantity) throws CloneNotSupportedException {
        //в список корзины добавляем товар, из листа продуктов по номеру num
        Product product = BDProduct.searchProduct(num);
        if (quantity <= product.getQuantity()) {
            Product product1 = product.clone();
            product1.setQuantity(quantity);
            cartProduct.add(product1);
        } else System.out.println("Вы хотите купить товара больше, чем есть в магазине");
    }

    public void printCart() {////правило DRY
        for (Product product : cartProduct) {
            System.out.println(product);
        }
    }

    public double cashCart() {// сумма покупки
        double sum = 0;
        for (Product product : cartProduct) {
            sum = sum + product.getPrice() * product.getQuantity();
        }
        return sum;
    }

    public void purchase() {//покупка товара. Уменьшаем количество товара в productList
        if (cashCart() <= user.getMany()) {
            for (Product pr : cartProduct) {
                BDProduct.purchaseQuantity(pr.getIdProduct(), pr.getQuantity());
            }
            System.out.println("Вы приобрели:");
            printCart();
            System.out.println("На сумму:" + this.cashCart());
            clearCart();
        } else System.out.println("Покупка невозможна, недостаточно средств");
    }

    public void clearCart() {//правило DRY
        cartProduct.clear();
    }

    public int sizeCart() {
        return cartProduct.size();
    }
}


