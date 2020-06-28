package pojo;

public class IconDetails {
    private int id;
    private String icon;
    private String name;
    private String color;
    private int type;

    public IconDetails() {
    }

    public IconDetails(int id, String icon, String name, String color, int type) {
        this.id = id;
        this.icon = icon;
        this.name = name;
        this.color = color;
        this.type = type;
    }

    @Override
    public String toString() {
        return "IconDetails{" +
                "id=" + id +
                ", icon='" + icon + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", type=" + type +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
