public class Alien{
    double damage;//stores the alien's damage
    double maxHp;//stores the alien's max hp
    double hp;//stores the alien's current hp
    double armor;//stores the alien's armor
    double heal;//stores the alien's heal value
    double deathCredits;//stores the amount of gold the player will receive for killing an alien
    public Alien(double idamage, double ihp, double iarmor, double iheal, double ideathCredits){
        damage = idamage;
        maxHp = ihp;
        hp = maxHp;
        armor = iarmor;
        heal = iheal;
        deathCredits = ideathCredits;
    }

    double alienAttack(){
        return damage;
    }

    public void alienDamaged(double i){
        i = i-(armor*.25);
        hp = hp-i;
    }

    public void alienHeal(){
        hp = hp+heal;
        if(hp>maxHp){
            hp = maxHp;
        }
    }
}
