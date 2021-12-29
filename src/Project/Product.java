package Project;

public class Product {
    private int detergent, carton_of_eggs, chocolate, chips, bread;
    private String l_m = "Lamb Meat", r_m = "Red Meat", p_m = "Pork Meat";
    public Product(int detergent, int carton_of_eggs, int chocolate, int chips, int bread, String l_m, String r_m, String p_m){
        this.p_m = p_m;
        this.r_m = r_m;
        this.l_m = l_m;
        this.bread = bread;
        this.chips = chips;
        this.chocolate = chocolate;
        this.carton_of_eggs = carton_of_eggs;
        this.detergent = detergent;
    }
}
