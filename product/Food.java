package product;

import unit.Unit;

public class Food extends Product { //принцип Liskov Substitution Principle
    private Unit unit; //принцип Dependency Inversion Principle

    public Food(String name, Double price, int quantity) {
        super(name, price, quantity);
    }

    public Food(String name, Double price, int quantity, Unit unit) {
        super(name, price, quantity);
        this.unit = unit;
    }
    @Override
    public String toString() {
        return super.toString() +"," +
                "ед.измерения = " + unit;
    }
}
