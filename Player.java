import java.util.*;//imports java utilities
class Player{
    String Name;//stores the player's name
    double hpMax = 100;//the maximum hp a player can have
    double hp = hpMax;//sets the player's starting hp to the max hp
    double money = 100;//stores the player's money (starts with 100)
    Armor startArmor = new Armor(2, 100, "Light Spacesuit", 0);//creates a starting armor object (does not actually need to be an object because my plans changed about halfway through)
    ArrayList <Weapon> WeaponList = new ArrayList <Weapon>();//gives the player their first weapon
    ArrayList <Medicine> MedicineList = new ArrayList <Medicine>();//creates a starting medicine object (does not actually need to be an object because my plans changed about halfway through)
    //adds a weapon to the player's inventory
    public void addWeapon(Weapon w){
        WeaponList.add(w);
    }
    //adds a medicine to the player's inventory
    public void addMedicine(Medicine m){
        MedicineList.add(m);
    }
    //checks if the player has enough ammo to attack then returns the damage
    public double playerAttack(){
        if(WeaponList.get(0).ammo > 0){
            WeaponList.get(0).ammo = WeaponList.get(0).ammo-1;
            return WeaponList.get(0).damage;
        }else{
            System.out.println("You try to shoot but do not have enough ammo to shoot");
            return 0;
        }
    }
    //checks if the player has enough medicine to heal then returns the heal value
    public double playerHeal(){
        if(MedicineList.get(0).uses>0){
            MedicineList.get(0).uses = MedicineList.get(0).uses - 1;
            return MedicineList.get(0).heal;
        }else{
            System.out.println("You try to heal but do not have enough medicine to heal");
            return 0;
        }
    }
    //takes the incoming damage and subtracts it from the player's hp, accounting for armor
    public void playerDamaged(double i){
        i = i-(startArmor.defense*.25);
        hp = hp - i;
    }
    //allows the player to pick their name
    public void chooseName(){
        System.out.println("Soldier, Please Enter Your Name:");
        Scanner input = new Scanner(System.in);
        Name = input.nextLine();
    }
    //prints the player's inventory
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
    //shows the inventory in the shop without taking the player back to the main menu
    public void showInventoryShop(Player p){
        System.out.println(Name + "'s Weapons are:");
        for(Weapon w: WeaponList){
            System.out.println(w.wName + " " + w.ammo + " ammo");
        }
        System.out.println(Name + " has " + MedicineList.get(0).uses + " medicine uses remaining");
        System.out.println(Name +" Has " + money + " Credits.");
        System.out.println(Name + " Has " + startArmor.aName);
    }
    //equips the inputted weapon by making the the first weapon on  the weapon arraylist
    public void equipWeapon(Weapon w){
        int index = WeaponList.indexOf(w);
        Weapon swap1 = WeaponList.get(0);
        WeaponList.set(0, w);
        WeaponList.set(index, swap1);
    }
}

