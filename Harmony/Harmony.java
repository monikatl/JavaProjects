import fundamental_date.CirclesOfFifths;
import harmonic_triad_builder.CreateHarmonicTriad;
import practise.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Harmony {

    private static Scanner input = new Scanner(System.in);
    private static CreateHarmonicTriad builder = new CreateHarmonicTriad();
    private static Practise exercise;

    public static void  main(String[] args) {

        System.out.println("\nWITAMY W APLIKACJI DO NAUKI HARMONII!\n");
        showDescription();

            while(true) {
            showMainMenu();
            String chose = input.next();
                switch (chose){
                case "k":
                   CirclesOfFifths.showCirclesOfFifths();
                    break;
                case "t":
                    builder.createAskHarmonicTriad();
                    break;
                case "p":
                    choseExercise();
                    break;
                case "s":
                    showDescription();
                    break;
                case "z":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Dokonaj prawidlowego wyboru!\n");
                }
            }
      }

    private static void showDescription() {
        System.out.println("Program pozwala na tworzenie triad harmonicznych w tonacjach do siedmiu znakow przykluczowych. " + "\n" +
                "Umozliwia trenning znajdowania akordow triady oraz budowania trojdzwiekow durowych i molowych.");
        System.out.println("('Cis' oznacza tonacje durowa - major, 'cis' oznacza tonacje molowa - minor.)");
    }

    private static void showMainMenu(){
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println("MENU: ");
        System.out.println("Wprowadz -- k -- aby wyswietlic kola kwintowe.");
        System.out.println("Wprowadz -- t -- aby stworzyc triade harmoniczna.");
        System.out.println("Wprowadz -- p -- aby sprawdzic swoja wiedze.");
        System.out.println("Wprowadz -- s -- aby wyswietlic opis programu.");
        System.out.println("Wprowadz -- z -- aby zakonczyc.");
        System.out.println("----------------------------------------------------");
    }

    private static void choseExercise(){
        int choice = 5;
        do{
            showPractiseMenu();
            exercise = null;
            try {
                choice = input.nextInt();
                chosePractise(choice);
                if(choice != 0) {
                    exercise.practise();
                }
            }catch (InputMismatchException | NullPointerException e){
                System.out.println("Dokonaj prawidlowego wyboru!");
                input.nextLine();
            }
        }while (choice != 0);
    }

    private static void chosePractise (int choice){
        switch (choice) {
            case 1:
                exercise = new TriadsPractise();
                break;
            case 2:
                exercise = new FunctionsPractise();
                break;
            case 3:
                exercise = new HarmonicTriadPractise();
                break;
            default:
                break;
        }
    }

    private static void showPractiseMenu(){
        System.out.println("------------------------------------------------------------");
        System.out.println("Wpisz -- 1 -- aby budowac trojdzwieki.");
        System.out.println("Wpisz -- 2 -- aby znajdowac akordy triady harmonicznej.");
        System.out.println("Wpisz -- 3 -- aby budowac triade harmoniczna.");
        System.out.println("Wpisz -- 0 -- aby wrocic do menu glownego.");
        System.out.println("------------------------------------------------------------");
    }
}



