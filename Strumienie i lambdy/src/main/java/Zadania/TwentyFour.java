package Zadania;

import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

public class TwentyFour {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        long userInput = input.nextInt();

        Predicate<Integer> isPrime = number -> {
            boolean prime = false;
            if(number < 2) {
                prime = false;
            }
            for(int i = 2; i * i <= number; i++) {
                if (number % i == 0) {
                    prime = false;
                }
                prime = true;
            }
            return prime;
        };

        IntStream.iterate(1, x -> x + 1)
                .boxed()
                .filter(isPrime)
                .limit(userInput)
                .forEach(System.out::println);
    }
}


