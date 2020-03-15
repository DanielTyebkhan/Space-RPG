import java.util.*;
public class Battle{
    Player player;
    Alien alien;
    boolean playerTurn;
    boolean alienTurn;
    boolean playerRan;

    public Battle(Player player, Alien alien) {
        this.player = player;
        this.alien = alien;
        playerTurn = true;
        alienTurn = false;
        playerRan = false;
        fight();
    }

    public void fight() {
        while (!player.isDead() && !alien.isDead() && !playerRan) {
            while (playerTurn && !playerRan) {
                int action = getPlayerInput();
                if (action == Player.ATTACK) {
                    alien.sustainDamage(player.attack());
                    if (alien.isDead()) {
                        playerTurn = false;
                        alienTurn = false;
                    }
                    playerTurn = false;
                    alienTurn = true;
                } else if (action == Player.HEAL) {
                    if (player.isFullHp()) {
                        System.out.println(player.getName() + " already has full hp");
                    } else {
                        player.heal();
                        playerTurn = false;
                        alienTurn = true;
                    }
                } else if (action == Player.RUN) {
                    if (player.canRun()) {
                        playerRan = true;
                    } else {
                        System.out.println(player.getName() + " is too weak and cannot run away");
                    }
                } else if (action == 4) {
                    player.equipWeapon();
                }
            }

            while (alienTurn && !playerRan) {
                if (alien.isFullHp()) {
                    System.out.println(alien.getName() + " Attacks!");
                    player.sustainDamage(alien.getDamage());
                } else {
                    double healChance = Math.random();
                    if (healChance > Alien.HEAL_LEVEL) {
                        System.out.println(alien.getName() + " Attacks!");
                        player.sustainDamage(alien.getDamage());
                    } else {
                        alien.heal();
                    }
                }
                alienTurn = false;
                playerTurn = true;
            }
        }
        determineResults();
    }
    public void determineResults(){
        if(alien.isDead()) {
            System.out.println(player.getName() + " has defeated " + alien.getName());
            player.addMoney(alien.getMoney());
            MenuMain.showMenuMain(player);
            MenuMain.menuMainAction(player);
        }else if(player.isDead()) {
            System.out.println(alien.getName() + " has defeated " + player.getName());
            player.die();
            MenuMain.showMenuMain(player);
            MenuMain.menuMainAction(player);
        }else if(playerRan) {
            System.out.println(player.getName() + " ran away.");
            MenuMain.showMenuMain(player);
            MenuMain.menuMainAction(player);
        }
    }

    public int getPlayerInput(){
        showOptions();
        Scanner input = new Scanner(System.in);
        while(!input.hasNextInt()){
            System.out.println("Please enter a valid number 1-4");
            input.nextLine();
        }
        int action = input.nextInt();
        while(action>4 || action<1){
            System.out.println("Please enter a valid number 1-4");
            input.nextLine();
            while(!input.hasNextInt()){
                System.out.println("Please enter a valid number 1-4");
                input.nextLine();
            }
            action = input.nextInt();
        }
        return action;
    }

    public void showOptions(){
        System.out.println("It is " + player.getName() + "'s turn. Please select an Action");
        System.out.println("1. Attack");
        System.out.println("2. Heal");
        System.out.println("3. Run");
        System.out.println("4. Change Weapons");
    }
}
