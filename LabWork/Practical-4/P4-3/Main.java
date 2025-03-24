public class Main {
    public static void main(String[] args) {
        Flat flat = new Flat("Sunview Apartment", 1000);
        Bungalow bungalow = new Bungalow("Green Villa", 1500, 800);

        System.out.println("Price of Flat: Rs. " + flat.computePrice());
        System.out.println("Price of Bungalow: Rs. " + bungalow.computePrice());
    }
}