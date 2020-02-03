import fundamental_date.CirclesOfFifths;
import harmonic_triad_builder.CreateHarmonicTriad;

import practise.*;
import tools.MenuConsoleChoice;

import java.util.Scanner;

import static tools.MenuConsoleChoice.*;
import static tools.Text.*;

public class Harmony {

    private static Scanner input = new Scanner(System.in);
    private static CreateHarmonicTriad builder = new CreateHarmonicTriad();
    private static Practise exercise;
    private static MenuConsoleChoice userChoice;

    public static void  main(String[] args) {


        System.out.println(WELCOME);
        System.out.println(DESCRIPTION);

        while (true) {
            showMainMenu();
            userChoice();
            switch (userChoice) {
                case k:
                    CirclesOfFifths.showCirclesOfFifths();
                    break;
                case t:
                    builder.createAskHarmonicTriad();
                    break;
                case p:
                    choseExercise();
                    break;
                case s:
                    System.out.println(DESCRIPTION);
                    break;
                case z:
                    System.exit(0);
                    break;
                default:
                    System.err.println(INCORRECT_CHOICE);
                    break;
            }
        }
    }

    private static void showMainMenu() {
        System.out.println(MENU);
        System.out.println(SEPARATOR);
        System.out.println(INPUT + k.name() + INPUT2 + k.getDescription());
        System.out.println(INPUT + t.name() + INPUT2 + t.getDescription());
        System.out.println(INPUT + p.name() + INPUT2 + p.getDescription());
        System.out.println(INPUT + s.name() + INPUT2 + s.getDescription());
        System.out.println(INPUT + z.name() + INPUT2 + z.getDescription());
        System.out.println(SEPARATOR);
    }

    private static void choseExercise() {

        do {
            showPractiseMenu();
            exercise = null;
            userChoice();
            chosePractise();
            try {
                exercise.practise();
            } catch (NullPointerException e) {
                if (!userChoice.equals(q)) {
                    System.err.println(INCORRECT_CHOICE );
                    input.nextLine();
                    userChoice();
                }
            }
        } while (!userChoice.equals(q));
    }

    private static void chosePractise (){
        switch (userChoice) {
            case n:
                exercise = new TriadsPractise();
                break;
            case b:
                exercise = new FunctionsPractise();
                break;
            case v:
                exercise = new HarmonicTriadPractise();
                break;
            case q:
                break;
        }
    }

    private static void userChoice(){
        String choice = input.next().toLowerCase();
        try {
            userChoice = valueOf(choice);
        }catch (IllegalArgumentException e){
            System.err.println(INCORRECT_CHOICE);
            userChoice();
        }
    }

    private static void showPractiseMenu(){
        System.out.println(SEPARATOR);
        System.out.println(INPUT + n.name() + INPUT2 + n.getDescription());
        System.out.println(INPUT + b.name() + INPUT2 + b.getDescription());
        System.out.println(INPUT + v.name() + INPUT2 + v.getDescription());
        System.out.println(INPUT + q.name() + INPUT2 + q.getDescription());
        System.out.println(SEPARATOR);
    }
}