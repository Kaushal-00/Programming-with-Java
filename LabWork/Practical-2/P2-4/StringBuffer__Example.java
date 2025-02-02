class StringBufferExample {

    public static void main(String[] args) {
        
        // Using the built-in StringBuffer class
        StringBuffer sb1 = new StringBuffer("Hello");
        System.out.println("Original StringBuffer: " + sb1);

        // Appending text
        sb1.append(" World!");
        System.out.println("After append: " + sb1);

        // Inserting text at a specific position
        sb1.insert(5, " Java");
        System.out.println("After insert: " + sb1);

        // Reversing the StringBuffer
        sb1.reverse();
        System.out.println("After reverse: " + sb1);

        // Converting StringBuffer to String
        String strFromBuffer = sb1.toString();
        System.out.println("String from StringBuffer: " + strFromBuffer);
    }
}
