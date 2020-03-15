/**
 * @author Daniel Tyebkhan
 */
public class Alien{
    private double damage;
    private double maxHp;
    private double hp;
    private double armor;
    private double heal;
    private double deathCredits;
    private String name;

    /**
     * Constructor
     * @param damage The alien's damage
     * @param hp The alien's hp
     * @param armor The alien's armor
     * @param heal The aliens heal capabilities
     * @param deathCredits The amount of credits the alien drops on death
     */
    public Alien(double damage, double hp, double armor, double heal, double deathCredits, String name){
        this.damage = damage;
        this.hp = hp;
        maxHp = this.hp;
        this.armor = armor;
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
     * Inflicts damage on the alien based on a given value and the alien's armor
     * @param damage the damage to deal to the alien
     */
    public void takeDamage(double damage){
        hp -= (damage-(armor*.25));
    }

    /**
     * Heals the alien based on its heal amount
     */
    public void heal(){
        hp = hp+heal;
        if(hp>maxHp){
            hp = maxHp;
        }
    }

    /**
     * Transforms the alien into a string
     * @return The alien's name, damage, hp, heal, armor, and credits
     */
    @Override
    public String toString(){
        return name + ":: Damage: " + damage + ":: Health: " + hp + "/" + maxHp + ":: Heal: " + heal +
                ":: Armor: " + armor + ":: Credits: " + deathCredits;
    }
}
