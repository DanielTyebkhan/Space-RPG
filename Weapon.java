public class Weapon{
    double damage;//instance variable for the weapon's damage
    double maxAmmo;//instance variable for the maximum ammo the weapon can hold
    double ammo;//instance variable for the amount of ammo the weapon has
    double wPrice;//instance variable for the price of the weapon
    String wName;//instance variable for the name of the weapon
    //the following is a constructor which sets the above variables
    public Weapon(double idamage, double imaxammo, double istartammo, String iwname, double iwPrice){
        damage = idamage;
        maxAmmo = imaxammo;
        ammo = istartammo;
        wName = iwname;
        wPrice = iwPrice;
    }
}
