public class InnerClassDemo {

    // Static Inner Class
    static class StaticInner {
        void show() {
            System.out.println("This is a Static Inner Class.");
        }
    }

    // Method containing Local Inner Class
    void displayLocalInnerClass() {

        class LocalInner {
            void show() {
                System.out.println("This is a Local Inner Class.");
            }
        }

        LocalInner local = new LocalInner();
        local.show();
    }

    // Method to demonstrate Anonymous Inner Class
    void displayAnonymousInnerClass() {
        
        Runnable r = new Runnable() {
            public void run() {
                System.out.println("This is an Anonymous Inner Class implementing Runnable.");
            }
        };

        Thread t = new Thread(r);
        t.start();
    }
}