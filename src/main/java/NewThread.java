import java.util.List;

public class NewThread extends Thread {
    private int nOfResources;
    ResourcePool<String> resource;

    public NewThread(int nOfResources, ResourcePool<String> resource) {
        this.nOfResources = nOfResources;
        this.resource = resource;
    }

    public void run() {
        if (nOfResources > resource.getSize()) {
            System.out.printf("%s not started \n There are not enough resources\n", Thread.currentThread().getName());
            return;
        }
        System.out.printf("%s started\n", Thread.currentThread().getName());
        List<String> freeResource = this.resource.getResource(this.nOfResources);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.resource.freeResources(freeResource);
        System.out.printf("%s finished\n", Thread.currentThread().getName());
    }
}
