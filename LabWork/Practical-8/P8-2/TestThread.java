public class TestThread {
    public static void main(String[] args) {
        Queue queue = new Queue();

        Thread producerThread = new Thread(new Producer(queue));
        Thread consumerThread1 = new Thread(new Consumer(queue));
        Thread consumerThread2 = new Thread(new Consumer(queue));

        producerThread.setPriority(Thread.NORM_PRIORITY + 1);
        consumerThread1.setPriority(Thread.NORM_PRIORITY - 1);
        consumerThread2.setPriority(Thread.NORM_PRIORITY - 1);
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();
    }
}
