package elements;

import elements.triad.*;
import lombok.Getter;
import tools.Text;

@Getter
public class HarmonicTriad {
    private Triads tonicTriad;
    private Triads subdominantTriad;
    private Triads dominantTriad;

    public HarmonicTriad(Triads tonicTriad, Triads subdominantTriad, Triads dominantTriad) {
        this.tonicTriad = tonicTriad;
        this.subdominantTriad = subdominantTriad;
        this.dominantTriad = dominantTriad;
    }

    @Override
    public String toString() {
         StringBuilder harmonicTriadBuilder = new StringBuilder();
          return  harmonicTriadBuilder.append(Text.TONIC)
                                    .append(tonicTriad.toString())
                                    .append(System.getProperty("line.separator"))
                                    .append(Text.SUBDOMINANT)
                                    .append(subdominantTriad)
                                    .append(System.getProperty("line.separator"))
                                    .append(Text.DOMINANT)
                                    .append(dominantTriad)
                                    .toString();
    }
}
