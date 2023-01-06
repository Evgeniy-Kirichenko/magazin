import bd.BDProduct;
import cart.Cart;
import user.User;

import java.util.Scanner;

import static bd.BDProduct.getProductList;


public class Main {
    private static final String[] mainMenu = {"Выберите действие",
            "1 - Вывод доступных для покупки товаров",
            "2 - Положить товар в корзину пользователя",
            "3 - Вывести на экран товар, который в корзине",
            "4 - Купить товар, который в корзине",
            "5 - Отказ от покупки",
            "0 - Выход"};

    private static boolean strIsNum(String str) {//проверяем, можно спарсить в int
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    private static int choice(Scanner scanner, String[] listOfChoice) {
        boolean carrent = false;
        int choiceInt = 0;
        for (String nameOfChoice : listOfChoice) {
            System.out.println(nameOfChoice);
        }
        String choice;
        do {
            System.out.print("Введите значение тут> ");
            choice = scanner.nextLine();
            if (strIsNum(choice)) {
                choiceInt = Integer.parseInt(choice);
                if (choiceInt < listOfChoice.length - 1) {
                    carrent = true;
                }
            } else {
                carrent = false;
            }
        } while (!carrent);
        return choiceInt;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User("Иван", 10000.00);
        Cart cart = new Cart(user);
        BDProduct.init();


        boolean exit = true;
        boolean submenu = false;
        int choice = 0;
        while (exit) {
            Scanner scanner = new Scanner(System.in);
            if (!submenu) {
                choice = choice(scanner, mainMenu);
                switch (choice) {
                    case 0:// выход
                        exit = false;
                        break;
                    case 1://список доступных продуктов
                        getProductList().forEach(System.out::println);
                        break;
                    case 2://корзина пользователя
                        System.out.print("Введите номер товара для добавления в корзину>");
                        String productNumStr = scanner.nextLine();
                        System.out.print("Введите количество товара добавления в корзину>");
                        String productQuantityStr = scanner.nextLine();
                        if (strIsNum(productNumStr) || strIsNum(productQuantityStr)) {
                            int productNum = Integer.parseInt(productNumStr);
                            int productQuantity = Integer.parseInt(productQuantityStr);
                            System.out.println("Товары добавленные в корзину:");
                            cart.addCart(productNum, productQuantity);
                            cart.printCart();
                        }
                        break;
                    case 3://печать корзины
                        cart.printCart();
                        System.out.println("Сумма покупки " + cart.cashCart());
                        break;
                    case 4://покупка товара
                        cart.purchase();
                        break;
                    case 5: //отказ от покупки
                        if (cart.sizeCart() > 0)
                            cart.clearCart();

                }

            }
        }
    }
}
