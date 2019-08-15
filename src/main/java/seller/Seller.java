package seller;

import java.io.Serializable;

public class Seller implements Serializable {

    private static final long serialVersionUID = 1L;

    private int seller_id;
    private String name;
    private String gender;
    private int age;
    private String email;
    private long telnumber;



    public Seller(){ }
    public Seller(String name, String gender, int age, String email, long telnumber){

        this.name = name;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.telnumber = telnumber;
    }
    public Seller(int seller_id, String name, String gender, int age, String email, long telnumber){

        this.seller_id = seller_id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.telnumber = telnumber;
    }

    public int getId() {
        return seller_id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(long telnumber) {
        this.telnumber = telnumber;
    }

}