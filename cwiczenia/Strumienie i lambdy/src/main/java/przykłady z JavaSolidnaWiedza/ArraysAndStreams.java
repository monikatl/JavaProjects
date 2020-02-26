import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysAndStreams {
    public static void main(String[] args) {
        Integer [] values = {2, 9, 5, 0, 3, 7, 1, 4, 8, 6};

        System.out.printf("Oryginalne wartosci: %s%n",
                Arrays.asList(values));

        System.out.printf("Posortowane wartosci: %s%n",
                Arrays.stream(values)
                      .sorted()
                      .collect(Collectors.toList()));

        List<Integer> greatherThan4 =
                Arrays.stream(values)
                      .filter(value -> value > 4)
                      .collect(Collectors.toList());

        System.out.printf("Wartosci wieksze od 4: %s%n", greatherThan4);

        System.out.printf("Posortowane wartosci wieksze od 4: %s%n",
                Arrays.stream(values)
                      .filter(value -> value > 4)
                      .sorted()
                      .collect(Collectors.toList()));

        System.out.printf("Wartosci wieksze od 4 (rosnaco w srumieniu): %s%n",
                greatherThan4.stream()
                             .sorted()
                             . collect(Collectors.toList()));
    }
}
