import java.util.ArrayList;

/**
 * @author Daniel Tyebkhan
 */
public class Shop{
    private static final int INVENTORY = 1;
    private static final int MENU = 2;
    private static final int AMMO = 3;
    private static final int START_LISTINGS = 4;

    private Player shopper;
    private ArrayList<Sellable> products;

    /**
     * Constructor
     * @param shopper The player who is shopping
     */
    public Shop(Player shopper){
        this.shopper = shopper;
        products = new ArrayList<>();
        addItem(new Weapon(50, 2, 5, "Big Gun", 1000));
        addItem(new Medicine(20, 5, "Big Medicine", 500));
        addItem(new Armor(5, "Advanced Armor", 350));
        shop();
    }

    /**
     * Shows the players options in the sop
     */
    private void showOptionsMain(){
        System.out.println(shopper.getName() + ", Welcome to the Space Station!");
        System.out.println(shopper.getName() + "'s credits: " + shopper.getMoney());
        System.out.println("Please Select an Item to Purchase or Action to Take");
        System.out.println(INVENTORY + ") View Inventory");
        System.out.println(MENU + ") Return to Orbit");
        System.out.println(AMMO + ") Ammunition Refill");
        showSellables();
    }

    /**
     * Shows the Sellables the player can purchase
     */
    private void showSellables(){
        int i = START_LISTINGS;
        for(Sellable s: products){
            System.out.println(i + ") " + s);
            i++;
        }
    }

    /**
     * Adds a Sellable to the shop
     * @param toAdd The Sellable to add
     */
    public void addItem(Sellable toAdd) {
        products.add(toAdd);
    }

    /**
     *
     */
    private void shop(){
        showOptionsMain();
        showSellables();
        System.out.println("What are you buying?");
        int action = shopper.getInput(1,START_LISTINGS+products.size()-1);
        if(action == INVENTORY){
            shopper.showInventory();
            shop();
        }else if(action == MENU){
            MenuMain.showMenuMain(shopper);
            MenuMain.menuMainAction(shopper);
        }else if(action == AMMO){
            refillAmmo();
        }else{
            sellItem(products.get(action - START_LISTINGS));
        }
    }

    private void refillAmmo(){
        System.out.println("Which gun would you like to refill?");
        shopper.showWeapons();
        System.out.println((shopper.getNumWeapons() + 1) + ") Back to Menu");
        refillAmmoAction(shopper.getInput(1, shopper.getNumWeapons() + 1));
    }

    private void refillAmmoAction(int action){
        if(action == shopper.getNumWeapons() + 1){
            shop();
        }else{
            if(shopper.getMoney() < 20){
                System.out.println("You don't have enough credits to purchase that");
            }else{
                shopper.takeMoney(20);
                shopper.refillWeapon(action);
                System.out.println("Ammo Refilled");
                refillAmmo();
            }
        }
    }

    public void sellItem(Sellable product){
        if(shopper.getMoney() < product.getPrice()){
            System.out.println("You don't have enough credits to purchase that");
        }else{
            shopper.takeMoney(product.getPrice());
            if(product instanceof Weapon) {
                shopper.addWeapon((Weapon) product);
            }else if(product instanceof Medicine){
                shopper.addMedicine((Medicine) product);
            }else if(product instanceof Armor){
                shopper.addArmor((Armor) product);
            }
        }
        shop();
    }

    public static void main(String[] args) {
        Player player = new Player(20, 10000);
        Shop shop = new Shop(player);
    }
}
