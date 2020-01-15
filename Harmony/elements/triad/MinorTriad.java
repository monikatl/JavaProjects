package elements.triad;

public class MinorTriad extends Triads implements Triad {

    public MinorTriad(String nameTriad) {
        super(nameTriad);
    }

    @Override
    public int findIndexOfSoundThird(int sound) {
        if (sound > 8) {
            return  (sound + 3) -12;
        } else {return sound + 3;}
    }
}
