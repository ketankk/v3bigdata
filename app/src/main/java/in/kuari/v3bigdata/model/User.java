package in.kuari.v3bigdata.model;

import java.io.Serializable;

/**
 * Created by ketan on 26/11/17.
 */

public class User implements Serializable{

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