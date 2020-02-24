import java.util.stream.IntStream;

public class AddStream {
    public static void main(String[] args) {
        System.out.printf("Suma liczb od 1 do 10 wynosi: %d%n",
                IntStream.rangeClosed(1, 10)
                            .sum());

        System.out.printf("Suma liczb parzystych od 2 do 20 wynosi: %d%n",
                IntStream.rangeClosed(1, 10)
                         .map((int x) -> {return x*2;})
                         .sum());

        System.out.printf("Suma trzykrotnosci liczb parzystych od 2 do 10 wynosi: %d%n",
                        IntStream.rangeClosed(1, 10)
                                 .filter(x -> x % 2 == 0)
                                 .map(x -> x * 3)
                                 .sum());
    }
}
