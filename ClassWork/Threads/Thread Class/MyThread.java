class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running...");
        System.out.println(Thread.currentThread().getName());
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        MyThread t1 = new MyThread(); // Create thread object
        t1.start(); // Start the thread (calls run() internally)
        t1.setName("Kaushal");
    }
}
