package user;

import product.Product;

import java.util.List;

public class User  { // пользователь
    private String name;
    private Double many;



    public User(String name,  Double many) {
        this.name = name;
        this.many = many;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMany() {
        return many;
    }

    public void setMany(Double many) {
        this.many = many;
    }

    @Override
    public String toString() {
        return "Имя пользователя = " + name +
                ", деньги = " + many +" р.";
    }

}
