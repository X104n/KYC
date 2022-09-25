package Customer;

import Customer.ICustomer;

import java.util.ArrayList;
import java.util.List;

public class Person implements ICustomer {

    // Mandatory data
    private String name;
    private String birth;
    private String country;
    private boolean isPep;

    // Optional data
    List<String> alias;
    List<String> sanctions;
    List<String> phones;
    List<String> emails;


    public Person(String name, String birth, String country, boolean isPep){

        this.name = name;
        this.birth = birth;
        this.country = country;
        this.isPep = isPep;
    }

    public void optionalData(List<String> alias, List<String> sanctions, List<String> phones, List<String> emails){
        this.alias = alias;
        this.sanctions = sanctions;
        this.phones = phones;
        this.emails = emails;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getBirth(){
        return birth;
    }

    public String getCountry(){
        return country;
    }
    @Override
    public boolean isPep() {
        return isPep;
    }

    public void move(String newCountry){
        this.country = newCountry;
    }

}
