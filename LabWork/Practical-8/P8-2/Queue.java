class Queue {
    private final int[] queue = new int[15];
    private int count = 0;

    public synchronized void produce(int item) {
        while (count == queue.length) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue[count++] = item;
        System.out.println("Produced: " + item);
        notifyAll();
    }

    public synchronized int consume() {
        while (count == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int item = queue[--count];
        System.out.println("Consumed: " + item);
        notifyAll();
        return item;
    }
}