package practise;

import elements.HarmonicTriad;

public class HarmonicTriadPractise implements Practise {
    private TriadsPractise triadTonic;
    private TriadsPractise triadSubdominant;
    private TriadsPractise triadDominant;
    private FunctionsPractise functions;
    private HarmonicTriad harmonicTriad;

    @Override
    public void practise() {
        buildHarmonicTriad();
        functions.showTonic();
        takeAnswer();
        userResult();
    }

    private void buildHarmonicTriad(){
        createHarmonicTriad();
        createTonicTriad();
        createSubdominantTriad();
        createDominantTriad();
    }

    private void createHarmonicTriad(){
        harmonicTriad = builder.buildHarmonicTriad(builder.randomKey());
        functions = new FunctionsPractise();
        functions.setRandomHarmonicTriadNames(builder.findNameOfHarmonicTriadFuncions(harmonicTriad.getTonicTriad().getNameTriad()));
    }

    private void createTonicTriad(){
        triadTonic = new TriadsPractise();
        triadTonic.setRandomTriad(harmonicTriad.getTonicTriad());
        triadTonic.createRandomTriadNames();
    }
    private void createSubdominantTriad(){
        triadSubdominant = new TriadsPractise();
        triadSubdominant.setRandomTriad(harmonicTriad.getSubdominantTriad());
        triadSubdominant.createRandomTriadNames();
    }
    private void createDominantTriad(){
        triadDominant = new TriadsPractise();
        triadDominant.setRandomTriad(harmonicTriad.getDominantTriad());
        triadDominant.createRandomTriadNames();
    }

    private void takeAnswer(){
        triadTonic.buildUserAnswer();
        String subdominant = functions.subdominant.input();
        triadSubdominant.buildUserAnswer();
        String dominant = functions.dominant.input();
        triadDominant.buildUserAnswer();
        functions.buildUserAnswer(subdominant, dominant);
    }

    private void userResult(){
        tonicResult();
        subdominantResult();
        dominantResult();
        functions.showResultOfCompare();
    }

    private void tonicResult(){
        System.out.println("\nTONIKA: ");
        triadTonic.compareThird();
        triadTonic.compareQuint();
        triadTonic.showResultOfCompare();
    }

    private void subdominantResult(){
        System.out.println("\nSUBDOMINANTA: ");
        functions.compareSubdominant();
        triadSubdominant.compareThird();
        triadSubdominant.compareQuint();
        triadSubdominant.showResultOfCompare();
    }

    private void dominantResult(){
        System.out.println("\nDOMINANTA: ");
        functions.compareDominant();
        triadDominant.compareThird();
        triadDominant.compareQuint();
        triadDominant.showResultOfCompare();
    }
}
