public class Medicine{
    private double uses;
    private double heal;
    private double price;
    private String name;

    public Medicine(double heal, double uses, String name, double price){
        this.heal = heal;
        this.uses = uses;
        this.name = name;
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    public String getName(){
        return name;
    }

    public double use(){
        if(!hasUses()){
            System.out.println("That medicine is empty");
            return 0;
        }
        uses -= 1;
        return heal;
    }

    private boolean hasUses(){
        return uses>0;
    }
}
