class Outer {
    interface NestedInterface {
        void show();
    }

    class Inner implements NestedInterface {
        public void show() {
            System.out.println("Implemented Nested Interface inside Outer class.");
        }
    }
}

class Main {
    public static void main(String[] args) {

        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.show();  
    }
}
