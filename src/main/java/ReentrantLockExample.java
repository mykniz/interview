import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    public static void main(String[] args) {
        CommonResource commonResource = new CommonResource();
        ReentrantLock reentrantLock = new ReentrantLock();
        for (int i = 1; i < 6; i++) {
            Thread t = new Thread(new CountThread(commonResource, reentrantLock));
            t.setName("Thread " + i);
            t.start();
        }
    }
}

class CommonResource {
    int x = 0;
}

class CountThread implements Runnable {

    CommonResource commonResource;
    ReentrantLock reentrantLock;

    public CountThread(CommonResource commonResource, ReentrantLock reentrantLock) {
        this.commonResource = commonResource;
        this.reentrantLock = reentrantLock;
    }

    @Override
    public void run() {
        reentrantLock.lock();
        try {
            commonResource.x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), commonResource.x);
                commonResource.x++;
                Thread.sleep(100);

            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            reentrantLock.unlock();
        }
    }
}