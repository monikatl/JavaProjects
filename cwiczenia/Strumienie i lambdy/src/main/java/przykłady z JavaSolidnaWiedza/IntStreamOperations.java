import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamOperations {
    public static void main(String[] args) {
        int [] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};

        System.out.print("Oryginalne wartosci: ");
        System.out.println(
                IntStream.of(values)
                         .mapToObj(String::valueOf)
                         .collect(Collectors.joining(" "))
        );

        System.out.printf("%nElementow: %d%n",
                IntStream.of(values).count());

        System.out.printf("Minimum: %d%n",
                IntStream.of(values).min().orElse(1));

        System.out.printf("Maximum: ",
                IntStream.of(values).max().getAsInt());

        System.out.printf("Suma: %d%n",
                IntStream.of(values).sum());

        System.out.printf("Srednia: %.2f%n",
                IntStream.of(values).average().getAsDouble());

        System.out.println(IntStream.of(values).summaryStatistics());

        System.out.printf("Suma poprzez metode reduce: %d%n",
                IntStream.of(values)
                         .reduce(0, (x, y) -> x + y));

        System.out.printf("Iloczyn poprzez metode reduce: %d%n",
                IntStream.of(values)
                         .reduce((x, y) -> x * y).getAsInt());

        System.out.printf("Suma kwadratøw poprzez map i sum: %d%n%n",
                IntStream.of(values)
                         .map(x -> x * x)
                         .sum());

        System.out.printf("Wartosci po posortowaniu: %s%n",
                IntStream.of(values)
                         .sorted()
                         .mapToObj(String::valueOf)
                         .collect(Collectors.joining(" ")));
    }
}
