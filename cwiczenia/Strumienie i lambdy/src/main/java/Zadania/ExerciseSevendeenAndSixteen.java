package Zadania;

import java.security.SecureRandom;

public class ExerciseSevendeenAndSixteen {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        random.ints(50, 1, 1000)
                .filter(number -> number % 2 != 0)
                .forEach(System.out::println);
    }
}
