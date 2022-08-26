package Project;

public class Product implements Specs, Specs_2 {
    private String name_of_the_product, date, or;
    private boolean is_it_1, is_it_2;
    private int q;
    public Product(String name_of_the_product, String date, String or, boolean is_it_1, boolean is_it_2, int q){
        this.name_of_the_product = name_of_the_product;
        this.date = date;
        this.or = or;
        this.is_it_1 = is_it_1;
        this.is_it_2 = is_it_2;
        this.q = q;
    }
    public String expiration_date(String date) {
        return date;
    }
    public String origin(String or) {
        return or;
    }
    public boolean is_Vegan(boolean is_it_1) {
        return is_it_1;
    }
    public boolean contains_Allergens(boolean is_it_2) {
        return is_it_2;
    }
    public int Quantity(int q) {
        return q;
    }
}
