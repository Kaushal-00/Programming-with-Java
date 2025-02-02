class StringExample {
    public static void main(String[] args) {

        String str1 = "Hello";
        System.out.println("Original String: " + str1);

        str1 = str1 + " World!";
        System.out.println("After concatenation: " + str1);

        String str2 = "Java Programming";
        System.out.println("Length of str2: " + str2.length());
        System.out.println("Character at position 5: " + str2.charAt(5));

        String str3 = "Java Programming";
        System.out.println("str2 equals str3: " + str2.equals(str3));
    }
}
