import Customer.Person;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Scanner;

public class KYC_Terminal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! Press (c) for list of commands");
        while (true) {

            String input = scanner.nextLine();
            if (input.toLowerCase().equals("q")) {
                System.exit(0);
            } else if (input.toLowerCase().equals("a")) {
                newPerson();
            } else if (input.toLowerCase().equals("s")) {
                searchPerson();
            } else if (input.toLowerCase().equals("p")) {
                printDatabase();
            } else if (input.toLowerCase().equals("c")) {
                commands();
            } else {
                System.out.println("Command not found. Please try again. Press (c) for commands");
            }
        }
    }

    private static void commands() {
        System.out.println("Search for pearson: (s)");
        System.out.println("Add new person: (a)");
        System.out.println("Print database: (p)");
        System.out.println("Quit: (q)");
    }

    private static void newPerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the person");
        String name = scanner.nextLine();

        System.out.println("Please enter the persons birth data (dd-mm-yyyy)");
        String birth = scanner.nextLine();

        System.out.println("Please enter the country the person is located");
        String country = scanner.nextLine();

        System.out.println("Please enter if the pearson is Politically Exposed (y/n)");
        boolean isPep = false;

        while (true) {
            String pep = scanner.nextLine();
            if (pep.toLowerCase().equals("y")) {
                isPep = true;
                break;
            } else if (pep.toLowerCase().equals("n")) {
                isPep = false;
                break;
            } else if (pep.toLowerCase().equals("q")) {
                System.exit(0);
            }
            System.out.println("Please answer (y) or (n). Press (q) to quit");
        }

        Person newPerson = new Person(name, birth, country, isPep);
    }

    private static void searchPerson() {
        System.out.println("Nothing here");

    }

    private static void printDatabase() {

    }


}