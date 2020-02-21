public class Medicine{
    double uses;//number of uses the medicine has left
    double heal;//how much hp the medicine gives
    double mPrice;//stores the price (I did not actually end up using this function)
    String mName;//stores the name of the medicine

    public Medicine(double iheal, double iuses, String imName, double imPrice){
        uses = iuses;
        heal = iheal;
        mName = imName;
        mPrice = imPrice;
    }
}
