public class Battle{
    Player player;
    Alien alien;
    boolean playerTurn;
    boolean alienTurn;
    boolean playerRan;

    /**
     * Constructor
     * @param player The player in the battle
     * @param alien The alien in the battle
     */
    public Battle(Player player, Alien alien) {
        this.player = player;
        this.alien = alien;
        playerTurn = true;
        alienTurn = false;
        playerRan = false;
        System.out.println(player.getName() + " has encountered " + alien.getName());
        fight();
    }

    /**
     * Runs the battle between the player and alien
     */
    public void fight() {
        while (!player.isDead() && !alien.isDead() && !playerRan) {
            while (playerTurn && !playerRan) {
                playerTurn();
            }
            while (alienTurn && !playerRan) {
                alienTurn();
            }
        }
        determineResults();
    }

    /**
     * Determines and executes the Alien's action in battle
     */
    private void alienTurn() {
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

    /**
     * Determines and executes the player's action Battle
     */
    private void playerTurn() {
        showOptions();
        int action = player.getInput(1,4);
        if (action == Player.ATTACK) {
            playerAttack();
        } else if (action == Player.HEAL) {
            playerHeal();
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

    /**
     * Determines whether the player can heal then heals them if they can
     */
    private void playerHeal() {
        if (player.isFullHp()) {
            System.out.println(player.getName() + " already has full hp");
        } else {
            double initialHp = player.getHp();
            player.heal();
            double finalHp = player.getHp();
            if (initialHp != finalHp) {
                playerTurn = false;
                alienTurn = true;
            }
        }
    }

    /**
     * Makes the player attack the alien
     */
    private void playerAttack() {
        alien.sustainDamage(player.attack());
        playerTurn = false;
        if(!alien.isDead()) {
            alienTurn = true;
        }
    }

    /**
     * Determines the results of the battle
     */
    public void determineResults(){
        if(alien.isDead()) {
            System.out.println(player.getName() + " has defeated " + alien.getName());
            player.addMoney(alien.getMoney());
            MenuMain.showMenuMain(player);
        }else if(player.isDead()) {
            System.out.println(alien.getName() + " has defeated " + player.getName());
            player.die();
            MenuMain.showMenuMain(player);
        }else if(playerRan) {
            System.out.println(player.getName() + " ran away.");
            MenuMain.showMenuMain(player);
        }
    }

    /**
     * Shows the player's battle options
     */
    public void showOptions(){
        System.out.println("It is " + player.getName() + "'s turn. Please select an Action");
        System.out.println("1. Attack");
        System.out.println("2. Heal");
        System.out.println("3. Run");
        System.out.println("4. Change Weapons");
    }
}
