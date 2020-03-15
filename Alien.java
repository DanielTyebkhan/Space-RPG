/**
 * @author Daniel Tyebkhan
 */
public class Alien{
    public static final double HEAL_LEVEL = 0.15;

    private double damage;
    private double maxHp;
    private double hp;
    private double defense;
    private double heal;
    private double deathCredits;
    private String name;

    /**
     * Constructor
     * @param damage The alien's damage
     * @param hp The alien's hp
     * @param defense The alien's armor
     * @param heal The aliens heal capabilities
     * @param deathCredits The amount of credits the alien drops on death
     */
    public Alien(double damage, double hp, double defense, double heal, double deathCredits, String name){
        this.damage = damage;
        this.hp = hp;
        maxHp = this.hp;
        this.defense = defense;
        this.heal = heal;
        this.deathCredits = deathCredits;
        this.name = name;
    }

    /**
     * Gets the Alien's name
     * @return The Alien's name
     */
    public String getName(){
        return name;
    }

    /**
     * Gets the damage the alien does
     * @return the alien's damage
     */
    public double getDamage(){
        return damage;
    }

    /**
     * Gets the amount of currency the alien has
     * @return The amount of money the alien has
     */
    public double getMoney(){
        return deathCredits;
    }

    /**
     * Inflicts damage on the alien based on a given value and the alien's armor
     * @param damage the damage to deal to the alien
     */
    public void sustainDamage(double damage){
        hp -= (damage-(defense *.25));
        if(hp<0){
            hp = 0;
        }
        System.out.println(name + " has " + hp + "/" + maxHp + " hp remaining");
    }

    /**
     * Heals the alien based on its heal amount
     */
    public void heal(){
        hp = hp+heal;
        if(hp>maxHp){
            hp = maxHp;
        }
        System.out.println(name + " healed.");
        System.out.println(name + " has " + hp + "/" + maxHp + " hp remaining");
    }

    /**
     * Checks if the alien is at full HP
     * @return true if the alien has full hp, else false
     */
    public boolean isFullHp(){
        return hp == maxHp;
    }

    /**
     * Checks if the alien is dead
     * @return true if the alien is dead, else false
     */
    public boolean isDead(){
        return hp<=0;
    }

    /**
     * Transforms the alien into a string
     * @return The alien's name, damage, hp, heal, armor, and credits
     */
    @Override
    public String toString(){
        return name + ":: Damage: " + damage + ":: Health: " + hp + "/" + maxHp + ":: Heal: " + heal +
                ":: Armor: " + defense + ":: Credits: " + deathCredits;
    }
}
