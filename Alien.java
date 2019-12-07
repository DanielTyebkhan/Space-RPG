public class Alien{
    double damage;//stores the alien's damage
    double maxHp;//stores the alien's max hp
    double hp;//stores the alien's current hp
    double armor;//stores the alien's armor
    double heal;//stores the alien's heal value
    double deathCredits;//stores the amount of gold the player will receive for killing an alien
    //constructor which sets the above variables
    public Alien(double idamage, double ihp, double iarmor, double iheal, double ideathCredits){
        damage = idamage;
        maxHp = ihp;
        hp = maxHp;
        armor = iarmor;
        heal = iheal;
        deathCredits = ideathCredits;
    }
    //method which returns the alien's damage when it attacks
    double alienAttack(){
        return damage;
    }
    //method where aliens hp is reduced accounting for the player's damage and the alien's armor
    public void alienDamaged(double i){
        i = i-(armor*.25);
        hp = hp-i;
    }
    //method which heals the alien
    public void alienHeal(){
        hp = hp+heal;
        if(hp>maxHp){
            hp = maxHp;
        }
    }
}
