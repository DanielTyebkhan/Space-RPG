public class Weapon{
    private double damage;
    private double maxAmmo;
    private double ammo;
    private double price;
    private String name;

    public Weapon(double damage, double maxAmmo, String name, double price){
        this.damage = damage;
        this.maxAmmo = maxAmmo;
        this.ammo = maxAmmo;
        this.name = name;
        this.price = price;
    }

    public double shoot(){
        if(ammo>0){
            ammo -= 1;
            return damage;
        }
        System.out.println("Not Enough Ammo");
        return 0;
    }

    public double getDamage(){
        return damage;
    }

    public double getAmmo(){
        return ammo;
    }

    public double getPrice(){
        return price;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name + ": Damage = " + damage + ": Ammo = " + ammo + "/" + maxAmmo;
    }
}
