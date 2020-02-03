package harmonic_triad_builder;

import elements.HarmonicTriad;
import elements.triad.Triads;
import fundamental_date.CirclesOfFifths;
import tools.NumberGenerator;
import java.util.Scanner;

public class CreateHarmonicTriad  {
    private CirclesOfFifths circles = new CirclesOfFifths();
    private Scanner input = new Scanner(System.in);

    public void createAskHarmonicTriad() {
        try {
            HarmonicTriad harmonicTriad = buildHarmonicTriad(userInputTonic());
            System.out.println(harmonicTriad);
        }catch (NullPointerException e){
            createAskHarmonicTriad();
        }
    }

     public String [] createRandomHarmonicTriadNames(){
        String tonic = randomKey();
        return findNameOfHarmonicTriadFuncions(tonic);
    }

     public String randomKey(){
        circles.setModeOfCircle(circles.choseModeOfCircle());
        final int REJECT_FIRST_KEY = 1;
        final int REJECT_LAST_KEY = 2;
        int scope = circles.getModeOfCircle().size()-REJECT_LAST_KEY;
        int randomNumber = NumberGenerator.generateNumber(scope, REJECT_FIRST_KEY);
        return circles.findTonic(randomNumber);
     }

    private  String userInputTonic() throws ArrayIndexOutOfBoundsException{
        System.out.print("Wpisz tonike: ");
        return input.next();
    }

    public HarmonicTriad buildHarmonicTriad(String tonic) {
        String [] funcionsOfHarmonicTriad = findNameOfHarmonicTriadFuncions(tonic);

        Triads tonicTriad = Triads.choseModeOfTriad(funcionsOfHarmonicTriad[0]);
        Triads subdominantTriad = Triads.choseModeOfTriad(funcionsOfHarmonicTriad[1]);
        Triads dominantTriad = Triads.choseModeOfTriad(funcionsOfHarmonicTriad[2]);

        HarmonicTriad harmonicTriad = new HarmonicTriad(tonicTriad, subdominantTriad, dominantTriad);

        tonicTriad.buildTriad(funcionsOfHarmonicTriad[0]);
        subdominantTriad.buildTriad(funcionsOfHarmonicTriad[1]);
        dominantTriad.buildTriad(funcionsOfHarmonicTriad[2]);

        return harmonicTriad;
    }

    public String [] findNameOfHarmonicTriadFuncions(String tonic){
        String [] functions  = new String[3];
        try {
            circles.setModeOfCircle(circles.choseModeOfCircle(tonic));
            functions[0] = tonic;
            functions[1] = circles.findSubdominant(tonic);
            functions[2] = circles.findDominant(tonic);
        } catch (ArrayIndexOutOfBoundsException  e){
            System.out.println("Wpisz prawidlowa tonacje! (do siedmiu znakow przykluczowych).\n");
        }
        return functions;
    }
}
