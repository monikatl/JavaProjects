package Zadania;

import java.util.List;
import java.util.Random;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ExerciseSeventeenAndFourteen {
    public static void main(String[] args) {

        List<Integer> myTab = choseRandomLetters();
        myTab.stream()
                .map(number -> String.valueOf(Character.toChars(number)))
                .distinct()
                .sorted()
                .forEach(letter -> System.out.printf("%s ", letter));
    }

    public static List<Integer> choseRandomLetters(){
        Random random = new Random();
        List<Integer> myList = random.ints(30, 65, 91)
                                        .boxed()
                                        .collect(Collectors.toList());
        return myList;
    }
}
