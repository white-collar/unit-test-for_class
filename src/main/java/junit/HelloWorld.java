package junit;

public class HelloWorld {
    private String name = "";

    public String getName() {
        return name;
    }

    public String getMessage() {
        if (name.equals("")) {
            return "Hello!";
        } else {
            return "Hello " + name + "!";
        }
    }

    public void setName(String name) {
        this.name = name;
    }
}
