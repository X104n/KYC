import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Scanner;

public class KYC_Terminal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Would you like to search for person(s) or add a new person to the database(a)?");
        String input = scanner.nextLine();
        if(input == "a"){
            newPerson();
        }

        /*
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

         */
    }

    private static void newPerson(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the person");
        String name = scanner.nextLine();

        System.out.println("Please enter the persons birth data (dd-mm-yyyy)");
        String birth = scanner.nextLine();

        System.out.println("Please enter the country the person is located");
        String country = scanner.nextLine();

        System.out.println("Please enter if the pearson is Politically Exposed (y/n)");
        boolean isPep;
        while(true){
            String pep = scanner.nextLine();
            if(pep.toLowerCase() == "y"){
                isPep = true;
            }
            else if(pep.toLowerCase() == "n"){
                isPep = false;
            }
            else if(pep.toLowerCase() == "q"){
                System.exit(0);
            }
            System.out.println("Please answer (y) or (n). Press (q) to quit");
        }

    }

    private void searchPerson(){

    }


}