import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Deposit implements Comparable<Deposit> {
    private double amountDeposit;
    private LocalDate actionDate;
    private LocalTime time;
    private PigManager pigManagerState;

    public Deposit(double amountDeposit){
        if(amountDeposit > 0) {
            this.amountDeposit = amountDeposit;
        }
    }

    public void setDate(){
        actionDate = LocalDate.now();
    }

    public double getAmountDeposit() {
        return amountDeposit;
    }

    public LocalDate getActionDate() {
        return actionDate;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime() {
        this.time = LocalTime.now();
    }

    public PigManager getPigManagerState() {
        return pigManagerState;
    }

    public void setPigManagerState(PigManager pigManagerState) {
        this.pigManagerState = pigManagerState;
    }

    public void createNewDeposit(PigManager pigManager){
        setDate();
        setTime();
        setPigManagerState(pigManager);
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "amountDeposit=" + amountDeposit +
                ", actionDate=" + actionDate +
                ", time=" + time +
                ", pigManagerState=" + pigManagerState +
                '}';
    }

    @Override
    public int compareTo(Deposit deposit) {
        return 0;
    }
}
