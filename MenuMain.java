import java.util.*;
public class MenuMain{

    public static void showMenuMain(Player p){
        System.out.println("Welcome to Orbit " + p.Name + "!");
        System.out.println("Please select an action:");
        System.out.println("1. Travel to Earth");
        System.out.println("2. Travel to Aiur (Heavy Weaponry Recommended)");
        System.out.println("3. Visit the Space Station");
        System.out.println("4. View your inventory");
    }

    public static void menuMainAction(Player p){
        //checks that user input is a valid number between 1 and 4
        Scanner input = new Scanner(System.in);
        while(!input.hasNextInt()){
            System.out.println("Please enter a valid integer response");
            input.nextLine();
        }
        int action = input.nextInt();
        while(action>4 || action<1){
            System.out.println("Please enter a valid integer response");
            input.nextLine();
            while(!input.hasNextInt()){
                System.out.println("Please enter a valid integer response");
                input.nextLine();
            }
            action = input.nextInt();
        }

        if(action == 1){
            Alien nomac = new Alien(5,50,1,1, 20);
            System.out.println(p.Name + " has encountered a Robot Nomac");
            Battle battle = new Battle(p, nomac);
        }

        if(action == 2){
            Alien Protoss = new Alien(20, 100, 0, 10, 100);
            System.out.println(p.Name + " has encountered a Protoss");
            Battle battle = new Battle(p, Protoss);
        }

        if(action == 3){
            Weapon w = new Weapon(50, 10, 10, "Big Gun", 200);
            Shop mainShop = new Shop(p, w);
            Shop.shopping(p);
        }

        if(action == 4){
            p.showInventory(p);
        }
    }
}
