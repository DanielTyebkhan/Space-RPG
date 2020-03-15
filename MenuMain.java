public class MenuMain{

    public static void showMenuMain(Player player){
        System.out.println("Welcome to Orbit " + player.getName() + "!");
        System.out.println("Please select an action:");
        System.out.println("1. Travel to Earth");
        System.out.println("2. Travel to Aiur (Heavy Weaponry Recommended)");
        System.out.println("3. Visit the Space Station");
        System.out.println("4. View your inventory");
    }

    public static void menuMainAction(Player player){
        int action = player.getInput(1,4);

        if(action == 1){
            Alien nomac = new Alien(5,50,.25,5, 20, "Nomac");
            System.out.println(player.getName() + " has encountered " + nomac.getName());
            Battle battle = new Battle(player, nomac);
        }

        if(action == 2){
            Alien protoss = new Alien(20, 100, 0, 10, 100, "Protoss");
            System.out.println(player.getName() + " has encountered " + protoss.getName());
            Battle battle = new Battle(player, protoss);
        }

        if(action == 3){
            Weapon w = new Weapon(50, 10, "Big Gun", 200);
            Shop mainShop = new Shop(player, w);
            Shop.shopping(player);
        }

        if(action == 4){
            player.showInventory();
        }
    }
}
