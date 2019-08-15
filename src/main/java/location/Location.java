package location;

import java.io.Serializable;

public class Location implements Serializable {

    private static final long serialVersionUID = 1L;

    private int location_id;
    private String name;


    public Location(){ }
    public Location(String name){

        this.name = name;

    }
    public Location(int location_id, String name){

        this.location_id = location_id;
        this.name = name;

    }

    public int getId() {
        return location_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}