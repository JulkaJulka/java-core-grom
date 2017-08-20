package lesson24.exercise;

/**
 * Created by user on 19.08.2017.
 */
public class Tool {
    private  String name;
    private String description;

    @Override
    public String toString() {
        return "Tool{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Tool(String name, String description) {
        this.name = name;
        this.description = description;


    }
}
