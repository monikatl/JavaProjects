import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;

public class Streamy {
    public static void main(String[] args) {
        SecureRandom generator = new SecureRandom();

        int [] myArray = generator.ints(25, 0, 101).toArray();
        List<Integer> myList = new LinkedList<>();

        for(int i : myArray){
            myList.add(i);
        }

        myList.stream()
                .forEach(System.out::println);
    }
}
