import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main{
    public static void main(String[] args) {
        int start = 1, end = 50;

        //Using Thread Class
        PrimeThread thread1 = new PrimeThread(start, end / 2);
        PrimeThread thread2 = new PrimeThread((end / 2) + 1, end);
        thread1.start();
        thread2.start();

        //Using Runnable Interface
        Thread runnableThread1 = new Thread(new PrimeRunnable(start, end / 2));
        Thread runnableThread2 = new Thread(new PrimeRunnable((end / 2) + 1, end));
        runnableThread1.start();
        runnableThread2.start();

        //Using Executor Framework
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new PrimeExecutor(start, end / 2));
        executor.execute(new PrimeExecutor((end / 2) + 1, end));
        executor.shutdown();
    }
}
