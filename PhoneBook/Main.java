import java.util.Scanner;

class Main {

    public static void main(String[] args)  {

        Scanner input = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();

        while (true){
            Main.showMainMenu();
            int option = input.nextInt();
            switch (option){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    phoneBook.showPhoneBook();
                    break;
                case 2:
                    Contact contact = phoneBook.searchContact();
                    if(contact == null){
                        System.out.println("Nie znaleziono kontaktu!");
                        System.out.println("Wpisz 1 aby dodac kontakt lub 0 aby wrocic do glownego menu:");
                        int chose = input.nextInt();
                        if(chose == 1){
                            phoneBook.addContact();
                        }else {
                            break;
                        }
                    } else {
                        System.out.println(contact);
                        System.out.print("Wpisz 1 aby edytowac kontakt, 2 aby usunac kontakt lub 0 aby wrocic do glownego menu: ");
                        int chose = input.nextInt();
                        if(chose == 1){
                            phoneBook.editContact(contact);
                        }else if (chose == 2){
                            phoneBook.deleteContact(contact);
                        }else{
                            break;
                        }
                    }
                    break;
                case 3:
                   phoneBook.addContact();
                    break;
                case 4:
                    phoneBook.writeContactsToFile();
                    break;
            }
            input.nextLine();
        }
    }

    public static void showMainMenu(){
        System.out.println();
        System.out.println("---------------------------------");
        System.out.println("Menu: ");
        System.out.println("Wprowadz: ");
        System.out.println("1 -- aby wyswietlic kontakty");
        System.out.println("2 -- aby wyszukac kontakt");
        System.out.println("3 -- aby dodac kontakt");
        System.out.println("4 -- aby zapisac kontakty w pliku");
        System.out.println("0 -- aby zakonczyc");
        System.out.println("---------------------------------");
        System.out.println();
    }
}


