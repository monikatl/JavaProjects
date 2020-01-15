package fundamental_date;

import tools.NumberGenerator;
import java.util.*;

public class CirclesOfFifths {

    static final String [] majorKeys = {"Fes", "Ces", "Ges", "Des", "As", "Es", "B", "F", "C", "G", "D", "A", "E", "H", "Fis", "Cis", "Gis"};
    static final String [] minorKeys = {"des", "as", "es", "b", "f", "c", "g", "d", "a", "e", "h", "fis", "cis", "gis", "dis", "ais", "eis"};
    final List<String> major = Arrays.asList(majorKeys);
    final List<String> minor = Arrays.asList(minorKeys);
    private List<String> modeOfCircle;

    public void setModeOfCircle(List<String> modeOfCircle) {
        this.modeOfCircle = modeOfCircle;
    }

    public List<String> getModeOfCircle() {
        return modeOfCircle;
    }

    public List<String> choseModeOfCircle(String tonic){
        if(major.contains(tonic)) {
           return major;
        }else{
           return minor;
        }
    }

    public  List <String> choseModeOfCircle(){
        if(NumberGenerator.generateNumber(2) == 0){
            return major;
        }else{
            return minor;
        }
    }

    public String findTonic(int indexOfTonic){
        return modeOfCircle.get(indexOfTonic);
    }

    public String findSubdominant (String tonic){
        int key = modeOfCircle.indexOf(tonic);
        return modeOfCircle.get(key-1);
    }

    public String findDominant (String tonic){
        int key = modeOfCircle.indexOf(tonic);
        String dominant = modeOfCircle.get(key+1);
        if(modeOfCircle.equals(minor)){
            char [] dominantChar = dominant.toCharArray();
            return dominant.replace(dominantChar[0], Character.toUpperCase(dominantChar[0]));
        }else {
            return dominant;
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
