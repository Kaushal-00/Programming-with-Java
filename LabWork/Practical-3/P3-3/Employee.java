class Employee {
    
    private String name;
    private double basicSalary;
    private double dearnessAllowance;

    // Constructor to initialize name and basic salary
    public Employee(String name, double basicSalary) {
        this.name = name;
        this.basicSalary = basicSalary;
        this.dearnessAllowance = 0.74 * basicSalary; // DA is 74% of Basic Salary
    }

    // Method to calculate TDS based on Gross Salary
    public double calculateTDS(double grossSalary) {
        if (grossSalary <= 100000) {
            return 0; // No TDS if Gross Salary is 100000 or less
        } else {
            return (grossSalary - 100000) * 0.10; // 10% TDS on the excess over 100000
        }
    }

    // Method to display the employee details and salary calculations
    public void displaySalaryDetails() {
        // Gross Salary = Basic Salary + Dearness Allowance
        double grossSalary = basicSalary + dearnessAllowance;

        // Calculate TDS
        double tds = calculateTDS(grossSalary);

        // Calculate Net Salary = Gross Salary - TDS
        double netSalary = grossSalary - tds;

        // Display the details
        System.out.println("Name: " + name);
        System.out.println("Basic Salary (Yearly): Rs. " + basicSalary);
        System.out.println("Dearness Allowance: Rs. " + dearnessAllowance);
        System.out.println("TDS Deducted: Rs. " + tds);
        System.out.println("Net Salary: Rs. " + netSalary);
    }
}