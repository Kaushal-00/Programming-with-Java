public class Main {

    public static void main(String[] args) {
        // Static Inner Class
        InnerClassDemo.StaticInner staticInner = new InnerClassDemo.StaticInner();
        staticInner.show();

        // Local Inner Class
        InnerClassDemo demo = new InnerClassDemo();
        demo.displayLocalInnerClass();

        // Anonymous Inner Class
        demo.displayAnonymousInnerClass();
    }
}
