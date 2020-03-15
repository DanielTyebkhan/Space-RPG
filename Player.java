import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Daniel Tyebkhan
 */
class Player{
    public static final int ATTACK = 1;
    public static final int HEAL = 2;
    public static final int RUN = 3;
    public static final int CHANGE_WEAPON = 4;
    public static final int CHANGE_MEDICINE = 5;
    public static final double RUN_THRESHOLD = .25;

    private String name;
    private double hpMax;
    private double hp;
    private double money;
    private ArrayList<Weapon> weaponList;
    private ArrayList<Medicine> medicineList;
    private ArrayList<Armor> armorList;

    /**
     * Constructor
     * @param hpMax The player's maximum health
     * @param money The player's starting money
     */
    public Player(double hpMax, double money){
        this.hpMax = hpMax;
        this.hp = hpMax;
        this.money = money;

        weaponList = new ArrayList <>();
        medicineList = new ArrayList <>();
        armorList = new ArrayList<>();
        armorList.add(new Armor(2, "Light Spacesuit", 0));
    }

    /**
     * Gets the player's name
     * @return The player's name
     */
    public String getName(){
        return name;
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
     */
    public void heal(){
        hp += medicineList.get(0).use();
        if(hp>hpMax){
            hp = hpMax;
        }
        System.out.println(name + " healed.");
        System.out.println(name + "'s hp: " + hp + "/" + hpMax);
    }

    /**
     * Checks if the player is dead
     * @return true if the player is dead, else false
     */
    public boolean isDead(){
        return hp <= 0;
    }

    /**
     * Checks if the player can run
     * @return true if the player can run, else false
     */
    public boolean canRun(){
        return hp/hpMax > RUN_THRESHOLD;
    }

    /**
     * Checks if the player is at full HP
     * @return true if the player's hp is full, else false
     */
    public boolean isFullHp(){
        return hp == hpMax;
    }

    /**
     * Makes the player take damage based on a given value and the player's equipped armor
     * @param damage The amount of damage the player sustains
     */
    public void sustainDamage(double damage){
        hp -= (damage - armorList.get(0).getDefense());
        System.out.println(name + " has " + hp + "/" + hpMax + " HP");
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
     */
    public void equipWeapon(){
        System.out.println("Select the Weapon to Equip:");
        showWeapons();
        int index = getInput(1, weaponList.size()) -1;
        Weapon swap1 = weaponList.get(0);
        weaponList.set(0, weaponList.get(index));
        weaponList.set(index, swap1);
        System.out.println(weaponList.get(index).getName() + " was equipped!");
    }

    public void showWeapons(){
        for(int i = 0; i<weaponList.size(); i++){
            System.out.println(i+1 + ") " + weaponList.get(i));
        }
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

    /**
     * Gets the users input between two numbers
     * @param min The minimum number for the input
     * @param max The maximum number for the input
     * @return The player's input
     */
    public int getInput(int min, int max){
        Scanner input = new Scanner(System.in);
        while(!input.hasNextInt()){
            System.out.println("Please enter a valid number:");
            input.nextLine();
        }
        int action = input.nextInt();
        while(action>max || action<min){
            System.out.println("Please enter a valid number:");
            input.nextLine();
            while(!input.hasNextInt()){
                System.out.println("Please enter a valid number:");
                input.nextLine();
            }
            action = input.nextInt();
        }
        return action;
    }

    /**
     * Gives the player currency
     * @param toAdd The amount of currency to give the player
     */
    public void addMoney(double toAdd){
        money += toAdd;
        System.out.println(name + " got " + toAdd + "credits.");
    }

    /**
     * Resets the player's hp and decreases its currency
     */
    public void die(){
        hp = hpMax;
        money -= 50;
    }
}

