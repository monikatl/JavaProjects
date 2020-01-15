import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    Converter converter;
    static String choice;


    public static void main(String[] args) {
        Main main = new Main();
        Scanner input = new Scanner(System.in);

        main.showMenu();
        choice = input.next();


        while(!choice.equals("q")){
            if(choice.equals("c") || choice.equals("f")){


                Converter calculator = main.choiceConverter(choice);
                System.out.println("Wpisz temperature: ");
                int temp;
                char c;

                    try {
                        temp = input.nextInt();
                        System.out.println("=  " + calculator.convert(temp));
                        main.showMenu();
                        choice = input.next();


                    } catch (InputMismatchException e) {

                            System.out.println("Blad! Wpisz cyfre!");
                            input.next();
                    }

            }else {
                System.out.println("Wprowadz poprawny wybor!");
                main.showMenu();
                choice = input.next();
            }

        }

    }

    public Converter choiceConverter (String choice){
        if(choice.equals("c")){
            converter = new FahrenheitConverter();
        }
        if (choice.equals("f")){
            converter = new CelsiusConverter();
        }
        return converter;
    }


    public void showMenu(){
        System.out.println("Witamy w konwerterze temperatury!");
        System.out.println("Menu: ");
        System.out.println("  wybierz --- c --- aby przeliczyc stopnie Celsjusza na Fahrenheita,");
        System.out.println("  wybierz --- f --- aby przeliczyc stopnie Fahrenheita na Celsjusza,");
        System.out.println("  wybierz --- q --- aby wyjsc z programu.");
    }

}
