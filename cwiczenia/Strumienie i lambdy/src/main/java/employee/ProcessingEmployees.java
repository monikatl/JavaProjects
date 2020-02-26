package employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProcessingEmployees {
    public static void main(String[] args) {
        Employee [] employees = {
                new Employee("Jan", "Kowalski", 5000, "IT"),
                new Employee("Anna", "Kusar", 7600, "IT")
        };

        List<Employee> list = Arrays.asList(employees);


        System.out.println("Kompletna lista pracownikow:");
        list.stream().forEach(System.out::println);

        Predicate<Employee> fourToSixThousand =
                e -> (e.getSalary() >= 4000 && e.getSalary() <= 6000);

        System.out.printf("%nPracownicy zarabiajacy od 4000 do 6000 zl miesiecznie posortowanie wedlug wysokosci wynagrodzenia:%n");
        list.stream()
                .filter(fourToSixThousand)
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);

        System.out.printf("%nPierwszy pracownik zarabiajacy od 4000 do 6000 zl:%n%s%n",
                list.stream()
                    .filter(fourToSixThousand)
                    .findFirst()
                    .get());

        Function<Employee, String> byFirstName = Employee::getFirstName;
        Function<Employee, String> byLastName = Employee::getLastName;

        Comparator<Employee> lastThenFirst =
                Comparator.comparing(byLastName).thenComparing(byFirstName);

        System.out.printf("%nPracownicy posortowani rosnaco po nazwisku i imieniu:%n");
                list.stream()
                    .sorted(lastThenFirst)
                    .forEach(System.out::println);


        System.out.printf("%nUnikatowe nazwiska pracownikow:%n");
        list.stream()
                .map(Employee::getLastName)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.printf(
                "%nPracownicy posortowani alfabetycznie po nazwisku i imieniu:%n"
        );
        list.stream()
                .sorted(lastThenFirst)
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.printf("%nPracownicy pogrupowani według działow:%n");
        Map<String, List<Employee>> groupedByDepartment =
                list.stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment));

        groupedByDepartment.forEach(
                (department, employeesInDepartment) -> {
                    System.out.printf("%n%s%n", department);
                    employeesInDepartment.forEach(
                            employee -> System.out.printf("  %s%n", employee)
                    );
                }
        );

        System.out.printf("%nLiczba pracownikow w kazdym dziale:%n");
        Map<String, Long> employeeCountByDepartment =
                list.stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        employeeCountByDepartment.forEach(
                (department, count) -> System.out.printf("%s ma %d pracownikow%n", department, count)
        );

        System.out.printf(
                "%nSuma zarobkow pracownikow (za pomoca metody sum): %.2f%n",
                list.stream()
                    .mapToDouble(Employee::getSalary)
                    .sum()
        );

        System.out.printf("" +
                "Suma zarobkow pracownikow (za pomoca metody reduce:) %.2f%n",
                list.stream()
                    .mapToDouble(Employee::getSalary)
                    .reduce(0, (x, y) -> x + y));

        System.out.printf("Srednia zarobkow pracownikow: %.2f%n",
                list.stream()
                    .mapToDouble(Employee::getSalary)
                    .average()
                    .getAsDouble());

    }
}
