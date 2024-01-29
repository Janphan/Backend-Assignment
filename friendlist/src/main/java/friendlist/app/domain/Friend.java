package friendlist.app.domain;

public class Friend {
    private String name;

    public Friend() {
    }

    public Friend(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Friend [name=" + name + "]";
    }

}
