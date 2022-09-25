import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MapTest {

    public static HashMap<String, List<String>> hashTest() {

        int randomInt = 10000;

        HashMap<String, List<String>> hash = new HashMap<>();

        ArrayList<String> list1 = new ArrayList<>(20);

        System.out.println(list1.size());
        System.out.println(list1);

        list1.add("Stian Munkejord");
        list1.add("Norge");
        list1.add("04.08.01");
        list1.set(5, "47168833");

        ArrayList<String> list2 = new ArrayList<>(20);

        list2.add("Stian Munkejord");
        list2.add("Norge");
        list2.add("04.08.02");

        Random random = new Random();

        hash.put(list1.get(0), list1);
        hash.put(list2.get(1), list2);

        return hash;

    }

    public static void main(String[] args) {
        HashMap<String, List<String>> myHash = hashTest();
        System.out.println(myHash);
    }
}
