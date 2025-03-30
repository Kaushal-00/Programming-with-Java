public class Main {
    public static void main(String[] args) {

        InvoiceDetail<Integer> invoice1 = new InvoiceDetail<>("Laptop Purchase", 50000, 5000);
        invoice1.displayDetails();
        System.out.println(invoice1.getInvoiceName());
        System.out.println(invoice1.getAmount());
        System.out.println(invoice1.getDiscount());

        invoice1.setAmount(70000);
        System.out.println(invoice1.getAmount());

        System.out.println();

        InvoiceDetail<Double> invoice2 = new InvoiceDetail<>("Online Course", 2499.99, 499.99);
        invoice2.displayDetails();
        System.out.println(invoice2.getInvoiceName());
        System.out.println(invoice2.getAmount());
        System.out.println(invoice2.getDiscount());

        invoice2.setAmount(3000.56);
        System.out.println(invoice2.getAmount());
    }
}