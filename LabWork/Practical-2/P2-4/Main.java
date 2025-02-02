public class Main {

    public static void main(String[] args) {
        
        System.out.println("==== String Class Example ====");
        String str = "Hello, Java!";
        System.out.println("Original String: " + str);

        str = str + " Welcome to the world of programming.";
        System.out.println("After concatenation: " + str);

        String subStr = str.substring(7, 11);
        System.out.println("Substring from index 7 to 11: " + subStr);

        String anotherStr = "Java";
        System.out.println("Is 'Java' equal to 'anotherStr': " + anotherStr.equals("Java"));

        System.out.println("\n==== StringBuffer Class Example ====");
        StringBuffer sb = new StringBuffer("Hello");
        System.out.println("Original StringBuffer: " + sb);

        sb.append(" World!");
        System.out.println("After append: " + sb);

        sb.insert(5, "Java ");
        System.out.println("After insert: " + sb);

        sb.reverse();
        System.out.println("After reverse: " + sb);

        // Converting StringBuffer to String
        String strFromBuffer = sb.toString();
        System.out.println("String from StringBuffer: " + strFromBuffer);
    }
}
