import java.security.SecureRandom;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class ExerciseSixteenPoitFourteen {
    public static void main(String[] args) {

        int [] arrayOfNumbers = new int[25];
        List<Integer> listOfNumbers = new LinkedList<>();

        for(int i = 0; i < 25; i++){
            arrayOfNumbers[i] = generateNumber();
        }

        for (int i = 0; i < 25; i++){
            listOfNumbers.add(arrayOfNumbers[i]);
        }

        System.out.printf("Wygenerowana pierwotnie lista: ");
        listOfNumbers.stream()
                    .forEach(number -> System.out.printf("%d ", number));

        System.out.printf("%nLista posortowana przy uzyciu strumienia: ");
        listOfNumbers.stream()
                .sorted()
                .forEach(number -> System.out.printf("%d ", number));

        System.out.printf("%nLista posortowana za pomoca Collections: ");
        Collections.sort(listOfNumbers);
        for (int number : listOfNumbers){
            System.out.print(number + " ");
        }

        System.out.printf("%nSuma elementow przy uzyciu strumienia: %d",
        listOfNumbers.stream()
                    .reduce(0, Integer::sum));

        int suma = 0;
        for(int number : listOfNumbers){
            suma += number;
        }
        System.out.printf("%nSuma elementow uzyskana za pomoca Collections: %d", suma);

        System.out.printf("%nSrednia uzyskana za pomoca strumienia: %f",
                IntStream.of(arrayOfNumbers)
                            .average().getAsDouble());

        double average = suma / listOfNumbers.size();
        System.out.printf("%nSrednia uzyskana za pomoca Collections: %f", average);

    }

    private static  int generateNumber(){
        SecureRandom numberGenerator = new SecureRandom();
        return numberGenerator.nextInt(101);
    }
}
