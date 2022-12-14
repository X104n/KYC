import Customer.Person;
import Database.DataBasePerson;

import java.util.ArrayList;
import java.util.Scanner;

public class KYC_Terminal {

    private static DataBasePerson dataBasePerson = new DataBasePerson();

    public static void main(String[] args) {
        initDatabase();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you admin? (y/n)");
        String input = scanner.nextLine();
        if (input.toLowerCase().equals("y")) {
            admin();
        } else {
            user();
        }
    }

    public static void user() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! Press (c) for list of commands");
        while (true) {

            String input = scanner.nextLine();
            if (input.toLowerCase().equals("q")) {
                System.exit(0);
            } else if (input.toLowerCase().equals("s")) {
                searchPerson();
            } else if (input.toLowerCase().equals("p")) {
                dataBasePerson.printDatabase();
            } else if (input.toLowerCase().equals("c")) {
                commands(false);
            } else {
                System.out.println("Command not found. Please try again. Press (c) for commands");
            }
        }
    }

    public static void admin() {
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
                dataBasePerson.printDatabase();
                System.out.println();
            } else if (input.toLowerCase().equals("c")) {
                commands(true);
            } else {
                System.out.println("Command not found. Please try again. Press (c) for commands");
            }
        }

    }

    private static void commands(boolean admin) {
        System.out.println("Search for person: (s)");
        if (admin)
            System.out.println("Add new person: (a)");
        System.out.println("Print database: (p)");
        System.out.println("Quit: (q)");
    }

    private static void newPerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the person");
        String name = scanner.nextLine();

        System.out.println("Please enter the person's birth data (dd-mm-yyyy)");
        String birth = scanner.nextLine();

        System.out.println("Please enter the country the person is located");
        String country = scanner.nextLine();

        System.out.println("Please enter if the person is Politically Exposed (y/n)");
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

        System.out.println("Would you like to give this person an ID? (y/n)");
        String input = scanner.nextLine();
        if (input.toLowerCase().equals("y")) {
            System.out.println("Please write an ID. The ID must be between 0 and " + dataBasePerson.getIDRange());
            input = scanner.nextLine();
            try {
                int ID = Integer.parseInt(input);
                if (!dataBasePerson.addNew(ID, newPerson)) {
                    dataBasePerson.addNew(newPerson);
                }
            } catch (IllegalArgumentException e) {
                dataBasePerson.addNew(newPerson);
            }
        } else {
            dataBasePerson.addNew(newPerson);
        }

        System.out.println("Thank you. Optional information WIP");
    }

    public static void searchPerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the ID of the pearson in question. Press (n) if you don't know the ID");
        String input = scanner.nextLine();
        try {
            int ID = Integer.parseInt(input);
            searchID(ID);
        } catch (NumberFormatException e) {
            if (input.toLowerCase().equals("n")) {
                searchUnknown();
            }
        }
        System.out.println();

    }

    private static void searchID(int ID) {
        Person person = dataBasePerson.getCustomer(ID);
        System.out.println("Printing info: ");
        person.printInfo();
    }

    private static void searchUnknown() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Search using: Name (n), birth (b), Country (c). Quit (q)");
            String input = scanner.nextLine();
            if (input.toLowerCase().equals("q")) {
                break;
            }
            if (input.toLowerCase().equals("n")) {
                System.out.println("Enter a name you would like to search: ");
                String name = scanner.nextLine();
                ArrayList<Person> foundNames = dataBasePerson.nameSearch(name);
                System.out.println("There where " + foundNames.size() + " results for " + name);
                for (Person p : foundNames) {
                    p.printInfo();
                }
                break;
            } else if (input.toLowerCase().equals("c")) {
                System.out.println("Enter a country you would like to search: ");
                String country = scanner.nextLine();
                ArrayList<Person> foundPersons = dataBasePerson.countrySearch(country);
                System.out.println("There where " + foundPersons.size() + " results for " + country);
                for (Person p : foundPersons) {
                    p.printInfo();
                    System.out.println();
                }
                break;
            } else {
                System.out.println("Please try again");
            }
        }

    }

    public static void initDatabase() {
        Person stian = new Person("Stian Munkejord", "04-08-2001", "Norway", false);
        dataBasePerson.addNew(1, stian);
        Person erna = new Person("Erna Solberg", "24-02-1961", "Norway", true);
        dataBasePerson.addNew(2, erna);
    }


}