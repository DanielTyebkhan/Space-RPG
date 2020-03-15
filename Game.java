import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Game{
    public static void main(String[] args){

        Player player = new Player(200, 500);
        player.chooseName();
        player.addWeapon(new Weapon(10,100, "Space Rifle", 0));
        player.addMedicine(new Medicine(10, 5, "Weak Medicine", 0));
        Alien alien = new Alien(5,30,1,1, 20, "Arachnid");
        System.out.println("Welcome to Space " + player.getName());
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
        System.out.println(player.getName() + " has encountered an Arachnid");
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch(InterruptedException e){
        }

        Battle intro = new Battle(player, alien);

        MenuMain.showMenuMain(player);
        MenuMain.menuMainAction(player);

    }
}
