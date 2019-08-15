package car;

import java.io.Serializable;

public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    private int car_id;
    private int seller_id;
    private int location_id;
    private String model;
    private String brand;
    private int age;
    private int mileage;
    private int price;
    private String colour;



    public Car(){ }
    public Car(int seller_id, int location_id, String model,
               String brand, int age, int mileage, int price, String colour){

        this.seller_id=seller_id;
        this.location_id=location_id;
        this.model = model;
        this.brand = brand;
        this.age = age;
        this.mileage = mileage;
        this.price = price;
        this.colour = colour;

    }

    public Car(int car_id, int seller_id, int location_id, String model,
               String brand, int age, int mileage, int price, String colour){

        this.car_id = car_id;
        this.seller_id=seller_id;
        this.location_id=location_id;
        this.model = model;
        this.brand = brand;
        this.age = age;
        this.mileage = mileage;
        this.price = price;
        this.colour = colour;
    }

    public int getId() {
        return car_id;
    }

    public int getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }



}
