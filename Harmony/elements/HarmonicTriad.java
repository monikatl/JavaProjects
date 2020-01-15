package elements;

import elements.triad.*;

public class HarmonicTriad {
    private Triads tonicTriad;
    private Triads subdominantTriad;
    private Triads dominantTriad;

    public HarmonicTriad(Triads tonicTriad, Triads subdominantTriad, Triads dominantTriad) {
        this.tonicTriad = tonicTriad;
        this.subdominantTriad = subdominantTriad;
        this.dominantTriad = dominantTriad;
    }

    public Triads getTonicTriad() {
        return tonicTriad;
    }

    public Triads getSubdominantTriad() {
        return subdominantTriad;
    }

    public Triads getDominantTriad() {
        return dominantTriad;
    }

    @Override
    public String toString() {
        return
                "Tonika: " + tonicTriad + "\n" +
                        "Subdominanta: " + subdominantTriad + "\n" +
                        "Dominanta: " + dominantTriad;
    }
}
