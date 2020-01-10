import java.util.*;

public class ResourcePool<T> {
    private int size;
    private Stack<T> resources;

    public ResourcePool(int size, T[] resources) {
        this.size = size;
        this.resources = new Stack<>();
        Arrays.stream(resources).forEach(x -> this.resources.push(x));
    }

    public synchronized List<T> getResource(int count) {
        List<T> resources = new LinkedList<>();
        while (this.resources.size() < count) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < count; i++) {
            resources.add(this.resources.pop());
        }
        return resources;
    }

    public int getSize() {
        return size;
    }

    public synchronized void freeResources(List<T> freeResources) {
        for (T t : freeResources) {
            resources.push(t);
        }
        notifyAll();
    }
}
