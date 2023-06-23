package project01;

public class Urunler {

    private String productName;
    private String producter;
    private int amount;
    private String unit;
    private String shelf=null;

    public Urunler (){

    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProducter() {
        return producter;
    }

    public void setProducter(String producter) {
        this.producter = producter;
    }

    public int getAmount() {
        return amount;
    }


    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
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
        String shelfString = null;
        if (shelf == null) {
            shelfString= "null" +shelf;
        }
        return "Urunler{" +
                "productName='" + productName + '\'' +
                ", producter='" + producter + '\'' +
                ", amount=" + amount +
                ", unit='" + unit + '\'' +
                ", shelf='" + shelfString + '\'' +
                '}';
    }



}
