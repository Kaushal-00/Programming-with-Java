public class WrapperClass {
    
    public static void main(String[] args) {
        // Integer Wrapper Class
        Integer num1 = Integer.valueOf(50);  // Creating an Integer object
        int num2 = num1.intValue();          // Converting Integer to int (Unboxing)
        System.out.println("Integer Value: " + num1);
        System.out.println("Unboxed Integer: " + num2);

        // Double Wrapper Class
        Double doubleNum = Double.valueOf(25.75);
        double primitiveDouble = doubleNum.doubleValue(); // Unboxing
        System.out.println("Double Value: " + doubleNum);
        System.out.println("Unboxed Double: " + primitiveDouble);

        // Character Wrapper Class
        Character ch = Character.valueOf('A');
        System.out.println("Character: " + ch);
        System.out.println("Is Letter? " + Character.isLetter(ch));  // Checking if it's a letter
        System.out.println("Is Digit? " + Character.isDigit(ch));    // Checking if it's a digit

        // Boolean Wrapper Class
        Boolean boolValue = Boolean.valueOf(true);
        System.out.println("Boolean Value: " + boolValue);
        System.out.println("Boolean (negation): " + !boolValue);

        // Parsing Strings to Primitive Types
        int parsedInt = Integer.parseInt("100");   // Converting String to int
        double parsedDouble = Double.parseDouble("50.25"); // Converting String to double
        System.out.println("Parsed Integer: " + parsedInt);
        System.out.println("Parsed Double: " + parsedDouble);

        // Autoboxing and Unboxing
        Integer autoBoxed = 30;  // Autoboxing (primitive to wrapper)
        int autoUnboxed = autoBoxed; // Unboxing (wrapper to primitive)
        System.out.println("Autoboxed Integer: " + autoBoxed);
        System.out.println("Auto-Unboxed Integer: " + autoUnboxed);
    }
}
