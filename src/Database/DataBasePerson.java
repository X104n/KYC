package Database;

import Customer.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

public class DataBasePerson implements IDataBase{
    private HashMap<Integer, Person> dataBase = new HashMap<Integer, Person>();
    private Random random = new Random();
    private int idRange = 10000;

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
    public Person getCustomer(int ID) {
        return dataBase.get(ID);
    }

    @Override
    public int getIDRange() {
        return idRange;
    }

    public void printDatabase(){
        for(int i : dataBase.keySet()){
            System.out.println("ID: " + i);
            dataBase.get(i).printInfo();
            System.out.println();
        }
    }

    public ArrayList<Person> nameSearch(String name){
        ArrayList<Person> search = new ArrayList<>();
        for (int i : dataBase.keySet()){
            String dataName = dataBase.get(i).getName();
            if(dataName.contains(name)){
                search.add(dataBase.get(i));
            }
        }
        return search;
    }

    public ArrayList<Person> countrySearch(String country){
        ArrayList<Person> search = new ArrayList<>();
        for (int i : dataBase.keySet()){
            String dataCountry = dataBase.get(i).getCountry();
            if(dataCountry.contains(country)){
                search.add(dataBase.get(i));
            }
        }
        return search;
    }
}
