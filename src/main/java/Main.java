import java.util.List;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        String[] resources = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};
        ResourcePool<String> pool = new ResourcePool(resources.length, resources);
        ExecutorOnResource executorOnResource = new ExecutorOnResource();

        for (int i = 0; i < 100; i++) {
            final int iFinal = i;
            Callable c = new Callable() {
                @Override
                public Object call() throws Exception {
                    System.out.println("Hello, world! " + iFinal);
                    Thread.sleep(1000);
                    return "";
                }
            };
            executorOnResource.execute(c);
        }


    }
}
