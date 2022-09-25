package Database;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class DataBasePerson implements IDataBase {
    private HashMap<Integer, List<String>> dataBase = new HashMap<Integer, List<String>>();
    private Random random = new Random();
    private int idRange;

    @Override
    public boolean addNew(int id, List<String> data){
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
    public void addNew(List<String> data){
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
    public List<String> updateCustomer(int ID) {
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
