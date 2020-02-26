import java.util.Arrays;
import java.util.stream.Collectors;

public class ArraysAndStreams2 {
    public static void main(String[] args) {
        String [] strings =
                {"Czerwony", "pomaranczowy", "Szary", "zielony", "Niebieski", "indygo", "Fioletowy"};

        System.out.printf("Pierwotne teksty: %s%n", Arrays.asList(strings));

        System.out.printf("Teksty z duzymi literami: %s%n",
                Arrays.stream(strings)
                      .map(String::toUpperCase)
                      .collect(Collectors.toList()));

        System.out.printf("Teksty mniejsze od n posortowane rosnaco: %s%n",
                Arrays.stream(strings)
                      .filter(s -> s.compareToIgnoreCase("n") < 0)
                      .sorted(String.CASE_INSENSITIVE_ORDER)
                      .collect(Collectors.toList()));

        System.out.printf("Teksty mniejsze od n posortowane malejaco: %s%n",
                Arrays.stream(strings)
                      .filter(s -> s.compareToIgnoreCase("n") < 0)
                      .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                      .collect(Collectors.toList()));
    }
}
