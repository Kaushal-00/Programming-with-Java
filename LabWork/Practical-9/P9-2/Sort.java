import java.util.*;

public class Sort {
    public static void main(String[] args) {
        
        int[] numbers = {5, 2, 8, 1, 3};
        Arrays.sort(numbers);
        System.out.println("Sorted Array: " + Arrays.toString(numbers));

        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Mango");
        Collections.sort(fruits);
        System.out.println("Sorted ArrayList: " + fruits);

        String word = "kaushal";
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        String sortedString = new String(chars);
        System.out.println("Sorted String Characters: " + sortedString);

        List<Integer> numList = Arrays.asList(10, 5, 7, 3, 2);
        Collections.sort(numList);
        System.out.println("Sorted List: " + numList);

        Map<Integer, String> map = new HashMap<>();
        map.put(3, "Banana");
        map.put(1, "Apple");
        map.put(2, "Mango");

        Map<Integer, String> sortedMap = new TreeMap<>(map); // Sorted by keys
        System.out.println("Sorted Map by Keys: " + sortedMap);

        Set<String> names = new HashSet<>();
        names.add("Zara");
        names.add("Aman");
        names.add("Bhavesh");

        Set<String> sortedSet = new TreeSet<>(names);
        System.out.println("Sorted Set: " + sortedSet);
    }
}
