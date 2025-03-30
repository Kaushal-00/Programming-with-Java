public class InvoiceDetail<N extends Number> {
    private String invoiceName;
    private N amount;
    private N discount;

    InvoiceDetail(String invoiceName, N amount, N discount) {
        this.invoiceName = invoiceName;
        this.amount = amount;
        this.discount = discount;
    }

    // Getters
    String getInvoiceName() {
        return invoiceName;
    }

    N getAmount() {
        return amount;
    }

    N getDiscount() {
        return discount;
    }

    // Setters
    void setInvoiceName(String invoiceName) {
        this.invoiceName = invoiceName;
    }

    void setAmount(N amount) {
        this.amount = amount;
    }

    void setDiscount(N discount) {
        this.discount = discount;
    }

    void displayDetails() {
        System.out.println("Invoice Name: " + invoiceName);
        System.out.println("Amount: " + amount);
        System.out.println("Discount: " + discount);
    }
}
