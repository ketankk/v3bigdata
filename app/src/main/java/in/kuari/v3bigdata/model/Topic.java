package in.kuari.v3bigdata.model;

/**
 * Created by ketan on 2/12/17.
 */


public class Topic{
    String name;
    String id;

    public Topic() {
    }

    public Topic(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}