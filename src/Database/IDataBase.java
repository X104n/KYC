package Database;

import Customer.Person;

import java.util.List;

public interface IDataBase {

    int IDRange = 10000;

    /**
     * Adds a new customer to the database with a specific ID
     * @param ID Specify the ID of the customer
     * @param data A list of data for the customer
     * @return if the ID was valid
     */
    public boolean addNew(int ID, Person data);

    /**
     * Adds the data to the database and assigns a random ID to the customer
     * @param data A list of data for the customer
     */
    public void addNew(Person data);

    /**
     * Gives the data to the customer in question
     * @param ID the ID of the customer
     * @return returns the data of the customer
     */
    public Person updateCustomer(int ID);

    /**
     * Use to search for a customer
     */
    public void searchCustomer();

    /**
     * @return the ID range
     */
    public int getIDRange();
}
