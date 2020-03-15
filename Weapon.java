/**
 * @author Daniel Tybekhan
 */
public class Weapon{
    private double damage;
    private double maxAmmo;
    private double ammo;
    private double price;
    private String name;

    /**
     * Constructor
     * @param damage The weapon's damage
     * @param maxAmmo The maximum ammunition the weapon can store
     * @param name The weapon's name
     * @param price The weapon's price
     */
    public Weapon(double damage, double maxAmmo, String name, double price){
        this.damage = damage;
        this.maxAmmo = maxAmmo;
        this.ammo = maxAmmo;
        this.name = name;
        this.price = price;
    }

    /**
     * Constructor
     * @param damage The weapon's damage
     * @param maxAmmo The maximum ammunition the weapon can store
     * @param name The weapon's name
     */
    public Weapon(double damage, double maxAmmo, String name){
        this.damage = damage;
        this.maxAmmo = maxAmmo;
        this.ammo = maxAmmo;
        this.name = name;
    }

    /**
     * Fires the weapon and removes ammunition
     * @return The weapon's damage if there is ammo remaining, else 0
     */
    public double shoot(){
        if(ammo>0){
            ammo -= 1;
            return damage;
        }
        System.out.println("Not Enough Ammo");
        return 0;
    }

    /**
     * Get's the weapon's damage
     * @return The weapon's damage value
     */
    public double getDamage(){
        return damage;
    }

    /**
     * Gets the amount of remaining ammunition in the weapon
     * @return The amount of remaining ammunition
     */
    public double getAmmo(){
        return ammo;
    }

    /**
     * Gets the weapon's price
     * @return The price of the weapon
     */
    public double getPrice(){
        return price;
    }

    /**
     * Gets the weapon's name
     * @return The weapon's name
     */
    public String getName(){
        return name;
    }

    /**
     * Transforms the weapon to a String
     * @return The weapon's name, damage, and ammunition
     */
    @Override
    public String toString(){
        return name + ": Damage = " + damage + ": Ammo = " + ammo + "/" + maxAmmo;
    }
}
