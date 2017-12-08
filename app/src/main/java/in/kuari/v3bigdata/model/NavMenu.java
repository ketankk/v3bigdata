package in.kuari.v3bigdata.model;


/**
 * Created by ketan on 25/11/17.
 */
public class NavMenu {
    private String id;
    private String icon;
    private String title;
    private boolean checkBox;
    public NavMenu(){

    }

    public NavMenu(String id){
        this.id=id;
    }
    public NavMenu(String id, String icon, String title) {
        this.id = id;
        this.icon = icon;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcon() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NavMenu navMenu = (NavMenu) o;

        return id.equals(navMenu.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
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
   /* List<NavMenu> menus=new ArrayList<>();
    NavMenu menu=new NavMenu(1,"https://cdn.onlinewebfonts.com/svg/img_253306.png","Option1");
    NavMenu menu2=new NavMenu(1,"https://cdn.onlinewebfonts.com/svg/img_253306.png", "option2");
*/