package Zadania;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ExerciseSeventeenTwentyThree {

    private static class Person{
        private String firstName;
        private String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getLastName() {
            return lastName;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Jan", "Nowak"));
        persons.add(new Person("Jakub", "Baszczyk"));
        persons.add(new Person("Zuzanna", "Pyzdek"));
        persons.add(new Person("Anna", "Nowak"));
        persons.add(new Person("Lukasz", "Pyzdek"));
        persons.add(new Person("Andrzej", "Nowak"));

        Predicate<Person> lastName = person -> person.getLastName().equals("Nowak");

        System.out.println(
                persons.stream()
                        .filter(lastName)
                        .findFirst()
                        .get());
    }
}


