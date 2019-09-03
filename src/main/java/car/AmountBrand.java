package car;

public class AmountBrand {
    String brand;
    int amount;

    public AmountBrand(String brand, int amount){
        this.brand=brand;
        this.amount=amount;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
