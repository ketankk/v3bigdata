package in.kuari.v3bigdata.model;

/**
 * Created by ketan on 26/11/17.
 */

public class User{

    public User(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}