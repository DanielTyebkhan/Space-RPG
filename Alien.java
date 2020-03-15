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

    /**
     * Constructor
     * @param damage The alien's damage
     * @param hp The alien's hp
     * @param armor The alien's armor
     * @param heal The aliens heal capabilities
     * @param deathCredits The amount of credits the alien drops on death
     */
    public Alien(double damage, double hp, double armor, double heal, double deathCredits){
        this.damage = damage;
        this.hp = hp;
        maxHp = this.hp;
        this.armor = armor;
        this.heal = heal;
        this.deathCredits = deathCredits;
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
}
