/**
 * @author Daniel Tyebkhan
 */
public class Armor{
    private double defense;
    private double price;
    private String name;

    /**
     * Constructor
     * @param defense The armor's defense value to reduce incoming damage
     * @param name The armor's name
     * @param price The armor's price
     */
    public Armor(double defense, String name, double price){
        this.defense = defense;
        this.name = name;
        this.price = price;
    }

    /**
     * Gets the armor's defense to subtract from incoming damage
     * @return The armor's defense value
     */
    public double getDefense(){
        return defense;
    }

    /**
     * Gets the armor's price
     * @return The armor's price
     */
    public double getPrice(){
        return price;
    }

    /**
     * Get's the armor's name
     * @return the name of the armor
     */
    public String getName(){
        return name;
    }

    /**
     * Overrides Object.toString to display relevent information about the armor
     * @return The armor's name and defense value
     */
    @Override
    public String toString(){
        return name + ": " + defense + " defense";
    }
    
    public static void main(String[] args) {
        System.out.println(new Armor(10, "Test Armor", 20));
    }
}
