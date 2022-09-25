package Customer;

import Customer.ICustomer;

public class Person implements ICustomer {

    String name;
    String birth;
    String country;
    boolean isPep;


    public void Person(String name, String birth, String country, boolean isPep){

        this.name = name;
        this.birth = birth;
        this.country = country;
        this.isPep = isPep;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean isPep() {
        return false;
    }
}
