//One known bug is that if the user enters input during the intro text sequence, the program will take that input the first opportunity it has, applying it to the battle that takes place after the intro.
//I was not able to figure out how to fix this. I tried closing the scanner as well as using a boolean to check when the player had entered input
//the game has no definite end
import java.util.Scanner;//imports the scanner utility
import java.util.concurrent.TimeUnit;//imports the concurrent TimeUnit utility
public class Game{
    public static void main(String[] args){
        //creates an initial player object for the user as well as an alien for the intro battle
        Player player1 = new Player();
        player1.addWeapon(new Weapon(10,100,100, "Space Rifle", 0));//gives the player their initial weapon
        player1.addMedicine(new Medicine(10, 5, "Weak Medicine", 0));//gives the player medicine
        Alien alien1 = new Alien(5,30,1,1, 20);
        player1.chooseName();//lets the player pick their name via the chooseName method in the Player class
        System.out.println("Welcome to Space " + player1.Name);
        //the following  code causes java to "go to sleep" for two seconds in between the intro text lines
        //this was done using the concurrentTimeUnit function in java which I learned how to do here: https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/TimeUnit.html
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
        //creates an intor battle between the player and a weak alien
        Battle intro = new Battle(player1, alien1);
        //creates a main menu object and runs the menuMainAction method
        MenuMain.showMenuMain(player1);
        MenuMain.menuMainAction(player1);

    }
}
