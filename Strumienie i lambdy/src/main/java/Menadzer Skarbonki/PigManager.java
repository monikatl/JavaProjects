public class PigManager {
    private double goal;
    private double pig;

    public PigManager() {
    }

    public PigManager(double goal, double pig) {
        this.goal = goal;
        this.pig = pig;
    }

    public double getGoal() {
        return goal;
    }

    public double getPig() {
        return pig;
    }

    public void setGoal(double goal) {
        this.goal = goal;
    }

    public void setPig(double pig) {
        this.pig = pig;
    }

    public void modify(double deposit) {
        goal = goal - deposit;
        pig = pig + deposit;
    }

    @Override
    public String toString() {
        return "PigManager{" +
                "goal=" + goal +
                ", pig=" + pig +
                '}';
    }
}
