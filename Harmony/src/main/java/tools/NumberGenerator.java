package tools;

import java.security.SecureRandom;

public class NumberGenerator {

    private static final SecureRandom randomNumber = new SecureRandom();

    public static int generateNumber(int scope, int move){
        return move + randomNumber.nextInt(scope);
    }
    
    public static boolean generateNumber(){
        return randomNumber.nextBoolean();
    }
}
