import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.function.Function;

public class Main {
    private final static List<Deposit> deposistsHistory = new ArrayList<>();
    private  PigManager pigManager = new PigManager(100000.00, 0.00);

    public static void main(String[] args) {

        Main main = new Main();

        main.addDepositToHistory(getInputFromUser());
        System.out.println(main.pigManager.getGoal());
        showHistory();

    }

    public void pushMercedesButton(){

    }

    public void addDepositToHistory(double inputDeposit){
        Deposit newDeposit = new Deposit(inputDeposit);
        newDeposit.createNewDeposit(pigManager);
        deposistsHistory.add(newDeposit);
        pigManager.modify(newDeposit.getAmountDeposit());
    }

    private static double getInputFromUser(){
        Scanner input = new Scanner(System.in);
        return input.nextDouble();
    }

    private static void showHistory(){
        Function<Deposit, LocalDate> byDate = Deposit::getActionDate;
        Function<Deposit, LocalTime> byTime = Deposit::getTime;
        Comparator<Deposit> dateCompare =
                Comparator.comparing(byDate).thenComparing(byTime);
        deposistsHistory.stream()
                        .sorted(dateCompare.reversed())
                        .forEach(System.out::println);
    }

}
