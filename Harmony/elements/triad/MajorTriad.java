package elements.triad;

import elements.Note;

public class MajorTriad extends Triads implements Triad {

    public MajorTriad(String nameTriad) {
        super(nameTriad);
    }

    public MajorTriad(Note prime, Note third, Note quint, String nameTriad) {
        super(prime, third, quint, nameTriad);
    }

    @Override
    public int findIndexOfSoundThird(int sound) {
        if (sound > 7) {
            return  (sound + 4) -12;
        } else {return sound + 4;}
    }
}
