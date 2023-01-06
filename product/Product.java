package product;

public abstract class Product implements Cloneable{// товары
    private static int idGlobal = 0;

    private int idProduct;
    private String name;
    private Double price;
    private int quantity;

    public Product(String name, Double price, int quantity) {
        idGlobal++;
        this.idProduct = idGlobal;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIdProduct() {
        return idProduct;
    }

    @Override
    public Product clone() throws CloneNotSupportedException {
        return (Product) super.clone();
    }

    @Override
    public String toString() {
        return
                "Номер=" + idProduct +
                ", Наименование = "  + name +
                ", Цена = " + price +
                " р. , Кол-во = " + quantity +
                " шт.";
    }
}
