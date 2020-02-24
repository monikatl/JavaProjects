import java.security.SecureRandom;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RandomIntStream {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();

        System.out.printf("%-8s%s%n", "Scianka", "Czestosc");
            random.ints(60_000_000, 1, 7)
                    .boxed()
                    .collect(Collectors.groupingBy(Function.identity(),
                    Collectors.counting()))
                    .forEach((face, frequency) -> System.out.printf("%-8d%d%n", face, frequency));
    }
}
