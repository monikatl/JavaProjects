public class FahrenheitConverter implements Converter {

    @Override
    public double convert(double temperature){
        return temperature * 1.8000 + 32.00;
    }

}
