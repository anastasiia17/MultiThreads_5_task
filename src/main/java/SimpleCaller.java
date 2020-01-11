import java.util.concurrent.Callable;

public class SimpleCaller {

    String name;

    SimpleCaller(String name) {
        this.name = name;
    }

    public void call(Callable c) {
        try {
            System.out.println("Executing on resource " + name);
            c.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
