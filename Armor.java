public class Armor{
    double defense;//stores the defense value
    double durability;//stores the durability(I did not end up implementing this feature)
    double aPrice;//stores the armor's price (no armor is currently available in the shop, but the code would be very similar to how weapons are sold and equipped)
    String aName;//stores the armors name

    public Armor(double idefense, double idurability, String iaName, double iaPrice){
        defense = idefense;
        durability = idurability;
        aName = iaName;
        aPrice = iaPrice;
    }
}
