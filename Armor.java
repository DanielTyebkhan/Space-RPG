/**
 * @author Daniel Tyebkhan
 */
public class Armor extends Sellable{
    private double defense;

    /**
     * Constructor
     * @param defense The armor's defense value to reduce incoming damage
     * @param name The armor's name
     * @param price The armor's price
     */
    public Armor(double defense, String name, double price){
        super(name, price);
        this.defense = defense;
    }

    /**
     * Gets the armor's defense to subtract from incoming damage
     * @return The armor's defense value
     */
    public double getDefense(){
        return defense;
    }

    /**
     * Transforms the weapon into a String
     * @return The armor's name and defense value
     */
    @Override
    public String toString(){
        return getName() + ": " + defense + " defense";
    }

    public static void main(String[] args) {
        System.out.println(new Armor(10, "Test Armor", 20));
    }
}
