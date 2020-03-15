import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Daniel Tyebkhan
 */
class Player{
    private String name;
    private double hpMax;
    private double hp;
    private double money;
    private ArrayList<Weapon> weaponList;
    private ArrayList<Medicine> medicineList;
    private ArrayList<Armor> armorList;

    /**
     * Constructor
     * @param name The player's name
     * @param hpMax The player's maximum health
     * @param money The player's starting money
     */
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


    /**
     * Add's a weapon to a player's inventory
     * @param weapon The weapon to add
     */
    public void addWeapon(Weapon weapon){
        weaponList.add(weapon);
    }

    /**
     * Adds medicine to a player's inventory
     * @param medicine The medicine to add
     */
    public void addMedicine(Medicine medicine){
        medicineList.add(medicine);
    }

    /**
     * Adds armor the to player's inventory
     * @param armor The armor to add
     */
    public void addArmor(Armor armor){
        armorList.add(armor);
    }

    /**
     * Makes the player attack
     * @return The value of the player's equipped weapon's damage
     */
    public double attack(){
        return weaponList.get(0).shoot();
    }

    /**
     * Makes the player heal
     * @return The value of the player's equipped medicine's heal
     */
    public double heal(){
        return medicineList.get(0).use();
    }

    /**
     * Makes the player take damage based on a given value and the player's equipped armor
     * @param damage The amount of damage the player sustains
     */
    public void sustainDamage(double damage){
        hp -= (damage - armorList.get(0).getDefense());
    }

    /**
     * Lets the user pick a name for the player
     */
    public void chooseName(){
        System.out.println("Soldier, Please Enter Your Name:");
        Scanner input = new Scanner(System.in);
        name = input.nextLine();
    }

    /**
     * Shows the players inventory
     */
    public void showInventory(){
        System.out.println(name + "'s Weapons are:");
        for(Weapon w: weaponList){
            System.out.println(w);
        }
        System.out.println(name + "'s Medicines are:");
        for(Medicine m: medicineList){
            System.out.println(m);
        }
        System.out.println(name + "'s Armors are:");
        for(Armor a: armorList){
            System.out.println(a);
        }
        System.out.println(name +" Has " + money + " Credits.");
        MenuMain.showMenuMain(this);
        MenuMain.menuMainAction(this);
    }

    /**
     * Lets the player change weapons
     * @param toEquip
     */
    public void equipWeapon(Weapon toEquip){
        int index = weaponList.indexOf(toEquip);
        Weapon swap1 = weaponList.get(0);
        weaponList.set(0, toEquip);
        weaponList.set(index, swap1);
        System.out.println(toEquip.getName() + " was equipped!");
    }

    /**
     * Lets the player change Armor
     * @param toEquip The armor for the player to equip
     */
    public void equipArmor(Armor toEquip){
        int index = armorList.indexOf(toEquip);
        Armor first = armorList.get(0);
        armorList.set(0, toEquip);
        armorList.set(index, first);
        System.out.println(toEquip.getName() + " was equipped");
    }

    /**
     * Lets the player change medicine
     * @param toEquip The medicine to equip
     */
    public void equipMedicine(Medicine toEquip){
        int index = medicineList.indexOf(toEquip);
        Medicine first = medicineList.get(0);
        medicineList.set(0, toEquip);
        medicineList.set(index, first);
        System.out.println(toEquip.getName() + " was equipped");
    }
}

