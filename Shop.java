import java.util.*;
public class Shop{
    static Player shopper = new Player();
    static Weapon weapon;
    public Shop(Player p, Weapon w){
        shopper = p;
        weapon = w;
        System.out.println(p.Name + ", Welcome to the Space Station!");
        System.out.println(p.Name + "'s credits: " + p.money);
        System.out.println("Please Select an Item to Purchase or Press 4 to See a List of Your Current Items");
        System.out.println("1. " + w.wName + "  " + w.wPrice + " Credits");
        System.out.println("2. 5 Medicine Refill 10 Credits");
        System.out.println("3. 20 Ammunition 10 Credits");
        System.out.println("4. View Inventory");
        System.out.println("5. Return to Orbit");
    }

    public static void shopping(Player p){
        System.out.println("What are you buying?");
        //gets user input between 1 and 5 
        Scanner input = new Scanner(System.in);
        while(!input.hasNextInt()){
            System.out.println("Please enter a valid number 1-5");
            input.nextLine();
        }
        int action = input.nextInt();
        while(action>5 || action<1){
            System.out.println("Please enter a valid number 1-5");
            input.nextLine();
            while(!input.hasNextInt()){
                System.out.println("Please enter a valid number 1-5");
                input.nextLine();
            }
            action = input.nextInt();
        }
        //determines which method to run based on the player's input
        if(action == 1){
            sellWeapon(p, weapon);
        }
        if(action == 2){
            sellMedicine(p);
        }
        if(action == 3){
            sellAmmo(p);
        }
        if(action == 4){
            p.showInventoryShop(p);
            Shop.shopping(p);
        }
        if(action == 5){
            MenuMain.showMenuMain(p);
            MenuMain.menuMainAction(p);
        }
    }

    public static void sellWeapon(Player p, Weapon w){
        if(p.money>= w.wPrice){
            p.money = p.money-w.wPrice;//reduces the player's currency by the price of the weapon
            p.WeaponList.add(w);
            p.equipWeapon(w);//runs the player method to equip the newly purchased weapon
            System.out.println(p.Name + " Purchased and Equipped " + w.wName);
            Shop.shopping(p);
            //if the player doesn't have enough credits, they are taken back to the shop
        }else{
            System.out.println(p.Name + " does not have enough credits to purchase " + w.wName);
            Shop.shopping(p);
        }
    }

    public static void sellMedicine(Player p){
        if(p.money>=50){
            p.money = p.money-10;//reduces the player's currency by 10
            p.MedicineList.get(0).uses = p.MedicineList.get(0).uses + 5;
            System.out.println(p.Name + " Purchased 5 Medicine Refill");
            Shop.shopping(p);
            //if the player doesn't have enough credits, they are taken back to the shop
        }else{
            System.out.println(p.Name + " does not have enough credits to purchase medicine");
            Shop.shopping(p);
        }
    }

    public static void sellAmmo(Player p){
        if(p.money>=10){
            p.money = p.money - 10;//reduces the player's currency by 10
            p.WeaponList.get(0).ammo = p.WeaponList.get(0).ammo + 20;//adds the ammo the player's equipped weapon
            if(p.WeaponList.get(0).ammo>p.WeaponList.get(0).maxAmmo){
                p.WeaponList.get(0).ammo = p.WeaponList.get(0).maxAmmo;//if the ammo added exceeds the equipped weapon's max ammo, the ammo is set to max ammo
            }
            System.out.println(p.Name + " Puchased more ammo"); 
            Shop.shopping(p);
        }else{
            System.out.println(p.Name + "does not have enough credits to purchase Ammo");
            Shop.shopping(p);
        }
    }
}
