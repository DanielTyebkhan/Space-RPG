public class Medicine{
    double uses;//instance variable to store the number of uses the medicine has left
    double heal;//instance variable for how much hp the medicine gives
    double mPrice;//stores the price (I did not actually end up using this function)
    String mName;//stores the name of the medicine
    //the following is a contstructor which sets all of the above variables
    public Medicine(double iheal, double iuses, String imName, double imPrice){
        uses = iuses;
        heal = iheal;
        mName = imName;
        mPrice = imPrice;
    }
}
