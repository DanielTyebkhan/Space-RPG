import java.util.concurrent.TimeUnit;

/**
 * @author Daniel Tyebkhan
 */
public class Game {
    private Player player;

    /**
     * Constructor creates a new player and puts it in an intro battle
     */
    public Game() {
        player = new Player(200, 100000);
        player.chooseName();
        player.addWeapon(new Weapon(10, 100, "Space Rifle"));
        player.addMedicine(new Medicine(10, 5, "Weak Medicine", 0));
        intro();
        MenuMain.showMenuMain(player);
    }

    /**
     * Runs the intro to the game
     */
    public void intro() {
        Alien alien = new Alien(5, 30, 1, 1, 20, "Arachnid");
        System.out.println("Welcome to Space " + player.getName());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
        }
        System.out.println("As one of the last humans left in the universe, you have been tasked with discovering a new planet to rebuild the human race on.");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
        }
        System.out.println("Your journey will be perilous and you will undoubtedly encounter scores of angry aliens and robots, waiting to wreak havoc on anything they come across.");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
        }
        System.out.println("AAAAAGH!");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
        }
        System.out.println(player.getName() + " has encountered an Arachnid");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
        }

        new Battle(player, alien);
    }

    public static void main(String[] args) {
        new Game();
    }
}

