package Zadania;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExerciseSeventeenPointThirteen {

    public static void main(String[] args) {
        String userSentence = userAsk();
        String [] words = createTabWithWords(userSentence);
        streamModyfySentence(words);
    }

    public static String userAsk(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Wpisz zdanie nie uzywajac znakow interpunkcyjnych i wcisnij enter.");
        return userInput.nextLine();
    }

    public static void streamModyfySentence(String [] words){
        List<String> wordsList = Arrays.asList(words);
        wordsList.stream()
                .distinct()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .forEach(System.out::println);
    }

    public static String [] createTabWithWords(String sentence){
        return sentence.split(" ");
    }
}
