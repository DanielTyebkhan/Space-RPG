public class MenuMain{

    public static void showMenuMain(Player player){
        System.out.println("Welcome to Orbit " + player.getName() + "!");
        System.out.println("Please select an action:");
        System.out.println("1. Travel to Earth");
        System.out.println("2. Travel to Aiur (Heavy Weaponry Recommended)");
        System.out.println("3. Visit the Space Station");
        System.out.println("4. View your inventory");
        System.out.println("5. Change your loadout");
        menuMainAction(player);
    }

    private static void menuMainAction(Player player){
        int action = player.getInput(1,5);

        if(action == 1){
            Alien nomac = new Alien(5,50,.25,5, 20, "Nomac");
            System.out.println(player.getName() + " has encountered " + nomac.getName());
            new Battle(player, nomac);
        }

        if(action == 2){
            Alien protoss = new Alien(20, 100, 0, 10, 100, "Protoss");
            System.out.println(player.getName() + " has encountered " + protoss.getName());
            new Battle(player, protoss);
        }

        if(action == 3){
            new Shop(player);
        }

        if(action == 4){
            player.showInventory();
            showMenuMain(player);
        }

        if(action == 5){
            player.changeLoadout();
            showMenuMain(player);
        }
    }
}
