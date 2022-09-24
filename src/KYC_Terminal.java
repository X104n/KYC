import java.util.Scanner;

public class KYC_Terminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name, organization and if the person is pep:");

        // String input
        String name = scanner.nextLine();

        // Numerical input
        int organization = scanner.nextInt();
        double salary = scanner.nextDouble();

        // Output input by user
        System.out.println("Name: " + name);
        System.out.println("Organization: " + organization);
        System.out.println("Salary: " + salary);

    }
}