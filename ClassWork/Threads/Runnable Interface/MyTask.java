class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread is running...");
    }
}

public class Main {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        task.start(); //it will give error because there is not implementation of start() in runnable...
        Thread t = new Thread(task);
        t.start();
    }
}
