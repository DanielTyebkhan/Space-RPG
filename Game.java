
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Game{
    public static void main(String[] args){

        Player player1 = new Player();
        player1.addWeapon(new Weapon(10,100,100, "Space Rifle", 0));//gives the player their initial weapon
        player1.addMedicine(new Medicine(10, 5, "Weak Medicine", 0));//gives the player medicine
        Alien alien1 = new Alien(5,30,1,1, 20);
        player1.chooseName();//lets the player pick their name via the chooseName method in the Player class
        System.out.println("Welcome to Space " + player1.Name);
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch(InterruptedException e){
        }
        System.out.println("As one of the last humans left in the universe, you have been tasked with discovering a new planet to rebuild the human race on.");
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch(InterruptedException e){
        }
        System.out.println("Your journey will be perilous and you will undoubtedly encounter scores of angry aliens and robots, waiting to wreak havoc on anything they come across.");
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch(InterruptedException e){
        }
        System.out.println("AAAAAGH!");
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch(InterruptedException e){
        }
        System.out.println(player1.Name + " has encountered an Arachnid");
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch(InterruptedException e){
        }

        Battle intro = new Battle(player1, alien1);

        MenuMain.showMenuMain(player1);
        MenuMain.menuMainAction(player1);

    }
}
