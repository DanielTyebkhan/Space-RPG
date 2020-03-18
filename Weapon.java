/**
 * @author Daniel Tybekhan
 */
public class Weapon extends Sellable{
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
     */
    public Weapon(double damage, double maxAmmo, String name){
        super(name, 0);
        this.damage = damage;
        this.maxAmmo = maxAmmo;
        this.ammo = maxAmmo;
    }

    /**
     * Constructor
     * @param damage The weapon's damage
     * @param ammo The weapon's starting ammunition
     * @param maxAmmo The weapon's ammunition capacity
     * @param name The weapon's name
     * @param price The weapon's price
     */
    public Weapon(double damage, double ammo, double maxAmmo, String name, double price){
        super(name, price);
        this.damage = damage;
        this.maxAmmo = maxAmmo;
        this.ammo = ammo;
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
     * Refills a weapon's ammunition
     */
    public void refillAmmo(){
        ammo = maxAmmo;
    }

    /**
     * Transforms the weapon to a String
     * @return The weapon's name, damage, and ammunition
     */
    @Override
    public String toString(){
        return getName() + ": Damage = " + damage + ": Ammo = " + ammo + "/" + maxAmmo;
    }
}
