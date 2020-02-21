public class Weapon{
    double damage;
    double maxAmmo;
    double ammo;
    double wPrice;
    String wName;
    public Weapon(double idamage, double imaxammo, double istartammo, String iwname, double iwPrice){
        damage = idamage;
        maxAmmo = imaxammo;
        ammo = istartammo;
        wName = iwname;
        wPrice = iwPrice;
    }
}
