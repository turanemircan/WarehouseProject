package project01;

public class Urunler {

    private String productName;
    private String producter;
    private int amount;
    private String unit;
    private String shelf;

    public Urunler (){

    }


    public Urunler(String productName, String producter, int amount, String unit, String shelf) {
        this.productName = productName;
        this.producter = producter;
        this.amount = amount;
        this.unit = unit;
        this.shelf = shelf;
    }

    @Override
    public String toString() {
        return "Urunler{" +
                "productName='" + productName + '\'' +
                ", producter='" + producter + '\'' +
                ", amount=" + amount +
                ", unit='" + unit + '\'' +
                ", shelf='" + shelf + '\'' +
                '}';
    }

}
