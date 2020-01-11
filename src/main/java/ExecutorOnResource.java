import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ExecutorOnResource {

    ResourcePool<SimpleCaller> threadPool;
    public ExecutorOnResource() {
        List l = new ArrayList<SimpleCaller>();
        for (int i = 0; i < 10; i++) {
            l.add(new SimpleCaller("Caller " + i));
        }
        threadPool = new ResourcePool<SimpleCaller>(10, (SimpleCaller[]) l.toArray(new SimpleCaller[0]));
    }

    public void execute(Callable callable) {
        List<SimpleCaller> res = threadPool.getResource(1);
        try {
            res.get(0).call(callable);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.freeResources(res);
        }
    }
}
