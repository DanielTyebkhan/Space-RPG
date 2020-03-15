import java.util.*;
public class Battle{
    Player player;
    Alien enemy;
    boolean playerTurn;
    boolean alienTurn;
    boolean playerRan;

    public Battle(Player player, Alien enemy) {
        this.player = player;
        this.enemy = enemy;
        playerTurn = true;
        alienTurn = false;
        playerRan = false;
        fight();
    }

    public void fight() {
        while (!player.isDead() && !enemy.isDead() && !playerRan) {
            while (playerTurn && !playerRan) {
                int action = getPlayerInput();
                if (action == Player.ATTACK) {
                    enemy.sustainDamage(player.attack());
                    if (enemy.isDead()) {
                        playerTurn = false;
                        alienTurn = true;
                    }
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
                if (enemy.isFullHp()) {
                    System.out.println(enemy.getName() + " Attacks!");
                    player.sustainDamage(enemy.getDamage());
                } else {
                    double healChance = Math.random();
                    if (healChance > Alien.HEAL_LEVEL) {
                        System.out.println(enemy.getName() + " Attacks!");
                        player.sustainDamage(enemy.getDamage());
                    } else {
                        enemy.heal();
                    }
                }
                alienTurn = false;
                playerTurn = true;
            }
        }
        determineResults();
    }
    public void determineResults(){
        if(enemy.isDead()) {
            System.out.println(player.getName() + " has defeated " + enemy.getName());
            player.addMoney(enemy.getMoney());
            MenuMain.showMenuMain(player);
            MenuMain.menuMainAction(player);
        }else if(player.isDead()) {
            System.out.println(enemy.getName() + " has defeated " + player.getName());
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
