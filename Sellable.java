/**
 * @author Daniel Tyebkhan
 */
public abstract class Sellable {
    private double price;
    private String name;

    /**
     * Constructor
     * @param name The Sellable's name
     * @param price The Sellable's price
     */
    public Sellable(String name, double price){
        this.name = name;
        this.price = price;
    }

    /**
     * Gets the Sellable's price
     * @return The price of the Sellable
     */
    public double getPrice(){
        return price;
    }

    /**
     * Gets the Sellable's name
     * @return The name of the Sellable
     */
    public String getName(){
        return name;
    }

    /**
     * Transforms the Sellable into a string
     * @return The Sellable's name and price
     */
    @Override
    public String toString(){
        return name + " price: " + price + " credits";
    }
}
