import java.util.*;

public class LetterTypeCount {
    public static void main(String[] args) {
        Map<String, Integer> myMap = new HashMap<>();

        createMap(myMap);
        displayMap(myMap);

    }

    private static void displayMap(Map<String, Integer> myMap) {
        Set<String> keys = myMap.keySet();
        TreeSet<String> sortedKeys = new TreeSet<>(keys);

        System.out.printf("%nOdwzorowanie zawiera:%nKlucz\t\tWartosc%n");

        for(String key : sortedKeys){
            System.out.printf("%-11s%10s%n", key, myMap.get(key));
        }
    }

    private static void createMap(Map<String, Integer> myMap) {
        Scanner input = new Scanner(System.in);
        System.out.println("Wpisz tekst:");
        String userInput = input.nextLine();

        String [] tokens = userInput.split(" ");

        for(String token : tokens){
            String word = token.toLowerCase();

            if(myMap.containsKey(word)){
                int count = myMap.get(word);
                myMap.put(word, count + 1);
            }else {
                myMap.put(word, 1);
            }
        }
    }
}
