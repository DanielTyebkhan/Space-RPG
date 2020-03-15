public abstract class Sellable {
    private double price;
    private String name;

    public Sellable(String name, double price){
        this.name = name;
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name + " price: " + price + " credits";
    }
}
