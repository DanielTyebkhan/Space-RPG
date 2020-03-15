import java.util.ArrayList;
import java.util.Scanner;

class Player{
    private String name;
    private double hpMax;
    private double hp;
    private double money;
    private ArrayList<Weapon> weaponList;
    private ArrayList<Medicine> medicineList;
    private ArrayList<Armor> armorList;

    public Player(String name, double hpMax, double money){
        this.name = name;
        this.hpMax = hpMax;
        this.hp = hpMax;
        this.money = money;

        weaponList = new ArrayList <>();
        medicineList = new ArrayList <>();
        armorList = new ArrayList<>();
        armorList.add(new Armor(2, "Light Spacesuit", 0));
    }

    public void addWeapon(Weapon weapon){
        weaponList.add(weapon);
    }

    public void addMedicine(Medicine medicine){
        medicineList.add(medicine);
    }

    public void addArmor(Armor armor){
        armorList.add(armor);
    }

    public double attack(){
        return weaponList.get(0).shoot();
    }

    public double heal(){
        return medicineList.get(0).use();
    }

    public void sustainDamage(double i){
        hp -= (i - armorList.get(0).getDefense());
    }

    public void chooseName(){
        System.out.println("Soldier, Please Enter Your Name:");
        Scanner input = new Scanner(System.in);
        name = input.nextLine();
    }

    public void showInventory(Player p){
        System.out.println(name + "'s Weapons are:");
        for(Weapon w: weaponList){
            System.out.println(w.wName + " " + w.ammo + " ammo");
        }
        System.out.println(name + " has " + medicineList.get(0).uses + " medicine uses remaining");
        System.out.println(name +" Has " + money + " Credits.");
        System.out.println(name + " Has " + startArmor.aName);
        MenuMain.showMenuMain(p);
        MenuMain.menuMainAction(p);
    }

    public void showInventoryShop(Player p){
        System.out.println(name + "'s Weapons are:");
        for(Weapon w: weaponList){
            System.out.println(w.wName + " " + w.ammo + " ammo");
        }
        System.out.println(name + " has " + medicineList.get(0).uses + " medicine uses remaining");
        System.out.println(name +" Has " + money + " Credits.");
        System.out.println(name + " Has " + startArmor.aName);
    }

    public void equipWeapon(Weapon w){
        int index = weaponList.indexOf(w);
        Weapon swap1 = weaponList.get(0);
        weaponList.set(0, w);
        weaponList.set(index, swap1);
    }
}

