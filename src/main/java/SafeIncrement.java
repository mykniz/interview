import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class SafeIncrement {
    public static void main(String[] args) throws Exception {
      //  demandLight();

        for (int i = 0; i < 1; i++) {
            new SafeIncrement().givenHashMap_whenSumParallel_thenError();
        }
    }

    volatile int count = 0;
    ReentrantLock lock = new ReentrantLock();

    void safeIncrement1() {
        // enter your code
        lock.lock();
        count++;
        lock.unlock();
        // enter your code
    }


    private AtomicBoolean atomicBoolean = new AtomicBoolean(false);
    void safeIncrement() {
        // enter your code
        do{
            count++;
        } while (atomicBoolean.compareAndSet(false,true));
    }


    static void demandLight() throws InterruptedException {
        AtomicBoolean a = new AtomicBoolean();
        Runnable waitGreen = () -> {
            System.out.println("wait....");
            while (!a.get()) {
                //....
            }
            System.out.println("go!");
        };

        new Thread(waitGreen).start();
        TimeUnit.MILLISECONDS.sleep(1000);
        a.compareAndSet(false,true);


    }



    public void givenHashMap_whenSumParallel_thenError() throws Exception {
//        Map<String, Integer> map = new HashMap<>();
//        List<Integer> sumList = parallelSum100(map, 100);

        Map<String, Integer> map = new ConcurrentHashMap<>();
        List<Integer> sumList = parallelSum100(map, 1000);

//        assertNotEquals(1, sumList
//                .stream()
//                .distinct()
//                .count());
        long wrongResultCount = sumList
                .stream()
                .filter(num -> num != 100)
                .count();

        System.out.println(wrongResultCount);

    }

    private List<Integer> parallelSum100(Map<String, Integer> map,
                                         int executionTimes) throws InterruptedException {
        List<Integer> sumList = new ArrayList<>(1000);
        for (int i = 0; i < executionTimes; i++) {
            map.put("test", 0);
            ExecutorService executorService =
                    Executors.newFixedThreadPool(4);
            for (int j = 0; j < 10; j++) {
                executorService.execute(() -> {
                    for (int k = 0; k < 10; k++)
                        map.computeIfPresent(
                                "test",
                                (key, value) -> value + 1
                        );
                });
            }
            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS);
            sumList.add(map.get("test"));
        }
        return sumList;
    }
}





