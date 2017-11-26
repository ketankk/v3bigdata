package in.kuari.v3bigdata.model;


/**
 * Created by ketan on 25/11/17.
 */
public class NavMenu {
    private long id;
    private String icon;
    private String title;
    private boolean checkBox;
    public NavMenu(){

    }
    public NavMenu(long id, String icon, String title) {
        this.id = id;
        this.icon = icon;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIconUrl() {
        return icon;
    }

    public void setIcon(String iconUrl) {
        this.icon = iconUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckBox() {
        return checkBox;
    }

    public void setCheckBox(boolean checkBox) {
        this.checkBox = checkBox;
    }

    @Override
    public String toString() {
        return "NavMenu{" +
                "id=" + id +
                ", icon='" + icon + '\'' +
                ", title='" + title + '\'' +
                ", checkBox=" + checkBox +
                '}';
    }
}
