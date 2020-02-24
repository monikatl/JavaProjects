package Zadania;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class InvoiceStream {
    public static void main(String[] args) {
        Invoice [] invoices = {
                new Invoice("83", "Szlifierka oscylacyjna", 7, 89.98),
                new Invoice("24", "Pila ogrodowa", 18, 69.99),
                new Invoice("7", "Mlot dwureczny", 11, 99.50),
                new Invoice("77", "Mlotek", 76, 21.99),
                new Invoice("39", "Kosiarka do trawy", 3, 299.50),
                new Invoice("68", "Srubokret", 105, 8.99),
                new Invoice("56", "Pila do metalu", 21, 18.99),
                new Invoice("3", "Klucz francuski", 34, 17.50)
        };

        List<Invoice> listInvoices = Arrays.asList(invoices);

        System.out.println("Obiekty posortowane po ilosci: ");
        listInvoices.stream()
                    .sorted(Comparator.comparing(Invoice::getQuantity))
                    .map(Invoice::getQuantityAndDescription)
                    .forEach(System.out::println);


        System.out.println();


        System.out.println("Obiekty posortowane po kwocie na fakturze:");
        listInvoices.stream()
                    .sorted(Comparator.comparing(Invoice::getInvoiceAmount))
                    .map(Invoice::getDescriptionAndInvoiceAmount)
                    .forEach(System.out::println);


        System.out.println();


        Predicate<Invoice> oneToFiveTousand =
                invoice -> (invoice.getInvoiceAmount() >= 1000 && invoice.getInvoiceAmount() <= 5000);

        System.out.println("Kwoty powyzej 1000 zł: ");
        listInvoices.stream()
                    .filter(oneToFiveTousand)
                    .sorted(Comparator.comparing(Invoice::getInvoiceAmount))
                    .map(Invoice::getDescriptionAndInvoiceAmount)
                    .forEach(System.out::println);

        System.out.println();

        String pila = "pila";
        Predicate<Invoice> pila = invoice -> invoice.getPartDescription().contains("");

        CharSequence k = "bla";
        String g = "bla";

        System.out.println("Wszystkie pily:");
        listInvoices.stream()
                    .filter(pila)
                    .forEach(System.out::println);

    }
}
