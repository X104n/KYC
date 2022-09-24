public class Person implements ICustomer {

    String name;
    String org;
    boolean isPep;

    public void Person(String name, String org, boolean isPep){

        this.name = name;
        this.org = org;
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
