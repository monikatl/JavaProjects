package practise;

import elements.triad.Triads;

public class TriadsPractise implements Practise, PractiseBuilder {
    private Triads randomTriad;
    private String [] randomTriadNames;
    private String [] userTriad;
    private boolean compareThird;
    private boolean compareQuint;

    @Override
    public void practise() {
        createRandomTriad();
        createRandomTriadNames();
        showPrime();
        buildUserAnswer();
        compareThird();
        compareQuint();
        showResultOfCompare();
    }

    public void createRandomTriad(){
        String randomPrime = builder.randomKey();
        randomTriad = Triads.choseModeOfTriad(randomPrime);
        randomTriad.buildTriad();
    }

    public void createRandomTriadNames(){
        randomTriadNames = randomTriad.downloadNamesOfNotes();
    }

    public void showPrime(){
        System.out.println("Zbuduj trojdzwiek " + randomTriad.showModeTriad() +
                            " od dzwieku: " + randomTriad.getPrime().getNote());
    }

    public boolean compareKeys(String user, String random){
        return user.equalsIgnoreCase(random);
    }

    public void buildUserAnswer(){
        userTriad = new String[2];
        userTriad[0] = third.input();
        input.nextLine();
        userTriad[1] = quint.input();
    }

    UserInput third = () -> {
        System.out.print("    Tercja akordu: ");
        return input.next();
    };

    UserInput quint = () -> {
        System.out.print("    Kwinta akordu: ");
        return input.next();
    };

    public void showResultOfCompare() {
        if(compareThird && compareQuint) {
            System.out.println("Brawo! Poprawnie zbudowany trojdzwiek akordu! ");
        }
    }

    public void compareThird(){
        compareThird = compareKeys(userTriad[0], randomTriadNames[1]);
        if (!compareThird) {
            System.out.println("Błedna tercja!");
            System.out.println("Poprawna tercja akordu to: " + randomTriadNames[1] + "-- ");
        }
    }

    public void compareQuint(){
        compareQuint = compareKeys(userTriad[1], randomTriadNames[2]);
        if (!compareQuint) {
            System.out.println("Błedna kwinta!");
            System.out.println("Poprawna kwinta akordu to: " + randomTriadNames[2] + "--");
        }
    }

    public void setRandomTriad(Triads randomTriad) {
        this.randomTriad = randomTriad;
    }
}
