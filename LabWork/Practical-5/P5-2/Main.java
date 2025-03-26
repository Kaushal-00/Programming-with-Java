public class Main{

    public static void main(String[] args) {
        // Static Inner Class
        StaticInner staticInner = new StaticInner();
        staticInner.show();

        // Local Inner Class
        InnerClassDemo demo = new InnerClassDemo();
        demo.displayLocalInnerClass();

        // Anonymous Inner Class
        demo.displayAnonymousInnerClass();
    }
}