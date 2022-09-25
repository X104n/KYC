package Database;

import Customer.Person;

import java.util.HashMap;
import java.util.Random;

public class DataBasePerson implements IDataBase{
    private HashMap<Integer, Person> dataBase = new HashMap<Integer, Person>();
    private Random random = new Random();
    private int idRange;

    @Override
    public boolean addNew(int id, Person data){
        // Check if the ID is valid
        if(dataBase.containsKey(id)){
            return false;
        }
        // Update ID range
        if(dataBase.size() >= idRange/2){
            idRange = idRange^2;
        }
        dataBase.put(id, data);
        Person person = new Person();
        return true;
    }

    @Override
    public void addNew(Person data){
        // Extends the ID range if there is a lot of customer
        if(dataBase.size() >= idRange/2){
            idRange = idRange^2;
        }

        // Assigns a random ID to the customer
        int newID = random.nextInt(idRange);
        while(dataBase.containsKey(newID)){
            newID = random.nextInt(idRange);
        }

        dataBase.put(newID, data);
    }

    @Override
    public Person updateCustomer(int ID) {
        return dataBase.get(ID);
    }

    @Override
    public void searchCustomer() {

    }

    @Override
    public int getIDRange() {
        return idRange;
    }
}