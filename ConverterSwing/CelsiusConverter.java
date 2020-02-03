public class CelsiusConverter implements Converter {

    @Override
    public double convert(double temperature) {
        return (temperature - 32) / 1.8000;
    }
}
