package fundamental_date;

import lombok.Getter;
import lombok.Setter;
import tools.NumberGenerator;
import java.util.*;

@Setter
@Getter
public class CirclesOfFifths {

    static final String [] majorKeys = {"Fes", "Ces", "Ges", "Des", "As", "Es", "B", "F", "C", "G", "D", "A", "E", "H", "Fis", "Cis", "Gis"};
    static final String [] minorKeys = {"des", "as", "es", "b", "f", "c", "g", "d", "a", "e", "h", "fis", "cis", "gis", "dis", "ais", "eis"};
    final List<String> major = Arrays.asList(majorKeys);
    final List<String> minor = Arrays.asList(minorKeys);

    private static final int STEP_CIRCLE = 1;

    private List<String> modeOfCircle;

    public CirclesOfFifths() {
    }

    public CirclesOfFifths(List<String> modeOfCircle) {
        this.modeOfCircle = modeOfCircle;
    }

    public List<String> choseModeOfCircle(String tonic){
        if(major.contains(tonic)) {
           return major;
        }else if (minor.contains(tonic)) {
            return minor;
        }else{
            throw new NullPointerException("Tonacja jest poza zakresem.");
        }
    }

     public  List <String> choseModeOfCircle(){
        if(NumberGenerator.generateNumber()){
            return major;
        }else{
            return minor;
        }
    }

    public String findTonic(int indexOfTonic){
        if(indexOfTonic < modeOfCircle.size()) {
            return modeOfCircle.get(indexOfTonic);
        }else{
            throw new ArrayIndexOutOfBoundsException("Ideks poza zakresem kola kwintowego.");
        }
    }

    public String findSubdominant (String tonic){
        return modeOfCircle.get(findIndexOfKey(tonic) - STEP_CIRCLE);
    }

    public int findIndexOfKey(String key){
        return modeOfCircle.indexOf(key);
    }

    public String findDominant (String tonic){
        String dominant = modeOfCircle.get(findIndexOfKey(tonic) + STEP_CIRCLE);
        return changeModeOfKey(dominant);
    }

    public String changeModeOfKey(String key){
        if(modeOfCircle.equals(minor)){
            char [] keyChar = key.toCharArray();
            return key.replace(keyChar[0], Character.toUpperCase(keyChar[0]));
        }else {
            return key;
        }
    }

    public static void showCirclesOfFifths(){
        System.out.println("KOLA KWINTOWE: ");
            showCircle(majorKeys);
            showCircle(minorKeys);
    }

    private static void showCircle(String [] keys){
        for (String key : keys) {
            System.out.print(key + "  ");
        }
        System.out.println();
    }

}
