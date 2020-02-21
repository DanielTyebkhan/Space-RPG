import java.util.*;//imports java utilities
class Player{
    String Name;//stores the player's name
    double hpMax = 100;//the maximum hp a player can have
    double hp = hpMax;//sets the player's starting hp to the max hp
    double money = 100;//stores the player's money (starts with 100)
    Armor startArmor = new Armor(2, 100, "Light Spacesuit", 0);//creates a starting armor 
    ArrayList <Weapon> WeaponList = new ArrayList <Weapon>();//gives the player their first weapon
    ArrayList <Medicine> MedicineList = new ArrayList <Medicine>();//creates a starting medicine 
    //adds a weapon to the player's inventory
    public void addWeapon(Weapon w){
        WeaponList.add(w);
    }

    public void addMedicine(Medicine m){
        MedicineList.add(m);
    }

    public double playerAttack(){
        if(WeaponList.get(0).ammo > 0){
            WeaponList.get(0).ammo = WeaponList.get(0).ammo-1;
            return WeaponList.get(0).damage;
        }else{
            System.out.println("You try to shoot but do not have enough ammo to shoot");
            return 0;
        }
    }

    public double playerHeal(){
        if(MedicineList.get(0).uses>0){
            MedicineList.get(0).uses = MedicineList.get(0).uses - 1;
            return MedicineList.get(0).heal;
        }else{
            System.out.println("You try to heal but do not have enough medicine to heal");
            return 0;
        }
    }

    public void playerDamaged(double i){
        i = i-(startArmor.defense*.25);
        hp = hp - i;
    }

    public void chooseName(){
        System.out.println("Soldier, Please Enter Your Name:");
        Scanner input = new Scanner(System.in);
        Name = input.nextLine();
    }

    public void showInventory(Player p){
        System.out.println(Name + "'s Weapons are:");
        //enhanced for loop to print the weapons
        for(Weapon w: WeaponList){
            System.out.println(w.wName + " " + w.ammo + " ammo");
        }
        System.out.println(Name + " has " + MedicineList.get(0).uses + " medicine uses remaining");
        System.out.println(Name +" Has " + money + " Credits.");
        System.out.println(Name + " Has " + startArmor.aName);
        //returns to main menu after displaying inventory
        MenuMain.showMenuMain(p);
        MenuMain.menuMainAction(p);
    }

    public void showInventoryShop(Player p){
        System.out.println(Name + "'s Weapons are:");
        for(Weapon w: WeaponList){
            System.out.println(w.wName + " " + w.ammo + " ammo");
        }
        System.out.println(Name + " has " + MedicineList.get(0).uses + " medicine uses remaining");
        System.out.println(Name +" Has " + money + " Credits.");
        System.out.println(Name + " Has " + startArmor.aName);
    }

    public void equipWeapon(Weapon w){
        int index = WeaponList.indexOf(w);
        Weapon swap1 = WeaponList.get(0);
        WeaponList.set(0, w);
        WeaponList.set(index, swap1);
    }
}

