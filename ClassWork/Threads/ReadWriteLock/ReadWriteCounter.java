import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// A shared counter class
public class ReadWriteCounter {

    private int count = 0; // shared resource

    // Create ReadWriteLock
    // From package: java.util.concurrent.locks
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    // Separate locks
    private final Lock readLock = lock.readLock();   // shared lock
    private final Lock writeLock = lock.writeLock(); // exclusive lock


    // WRITE METHOD
    // Only one thread allowed at a time
    public void increment() {

        writeLock.lock(); // acquire write lock (blocks readers & writers)

        try {
            count++; // modifying shared data
        } finally {
            writeLock.unlock(); // must release
        }
    }


    // READ METHOD
    // Multiple threads allowed simultaneously
    public int getCount() {

        readLock.lock(); // acquire read lock (many readers allowed)

        try {
            return count; // just reading, no modification
        } finally {
            readLock.unlock(); // release read lock
        }
    }


    public static void main(String[] args) throws InterruptedException {

        ReadWriteCounter counter = new ReadWriteCounter();

        // READER THREAD TASK
        Runnable readTask = new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {

                    // Many threads can execute this together
                    System.out.println(
                        Thread.currentThread().getName()
                        + " read: " + counter.getCount()
                    );

                    try { Thread.sleep(100); } catch (Exception e) {}
                }
            }
        };


        // WRITER THREAD TASK
        Runnable writeTask = new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {

                    // Only ONE thread can execute this at a time
                    counter.increment();

                    System.out.println(
                        Thread.currentThread().getName()
                        + " incremented"
                    );

                    try { Thread.sleep(150); } catch (Exception e) {}
                }
            }
        };


        // Create threads
        Thread writerThread  = new Thread(writeTask, "Writer");
        Thread readerThread1 = new Thread(readTask, "Reader-1");
        Thread readerThread2 = new Thread(readTask, "Reader-2");

        // Start threads
        writerThread.start();
        readerThread1.start();
        readerThread2.start();

        // Wait for completion
        writerThread.join();
        readerThread1.join();
        readerThread2.join();

        // Final value
        System.out.println("Final count: " + counter.getCount());
    }
}
