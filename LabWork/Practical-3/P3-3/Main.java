import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Basic Salary: ");
        double basicSalary = sc.nextDouble();

        Employee employee = new Employee(name, basicSalary);

        employee.displaySalaryDetails();

        sc.close();
    }
}
