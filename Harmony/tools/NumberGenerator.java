package tools;

import java.security.SecureRandom;

public class NumberGenerator {

    private static final SecureRandom randomNumber = new SecureRandom();

    public static int generateNumber(int numbers){
        return randomNumber.nextInt(numbers);
    }

    public static int generateNumber(int numbers, int move){
        return move  + randomNumber.nextInt(numbers);
    }
}
