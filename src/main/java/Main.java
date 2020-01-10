public class Main {
    public static void main(String[] args) {
        String[] resources = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};
        ResourcePool<String> pool = new ResourcePool(resources.length, resources);
        for (int i = 0; i < 10; i++) {
            new NewThread(3, pool).start();
        }
    }
}
