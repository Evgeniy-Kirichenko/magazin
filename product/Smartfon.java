package product;

public class Smartfon extends Product{
    private String country;

    public Smartfon(String name, Double price, int quantity) {
        super(name, price, quantity);
    }

    public Smartfon(String name, Double price, int quantity, String country) {
        super(name, price, quantity);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return super.toString() +"," +
                "страна = " + country ;
    }
}
