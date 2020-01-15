import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class PhoneBook {
    Scanner input = new Scanner(System.in);
    ValidateInput validate = new ValidateInput();
    List<Contact> myPhoneBook = new ArrayList<>();

    public void showPhoneBook(){
        System.out.println("-------- Moje kontakty ---------- ");
        for(int i = 0; i < myPhoneBook.size(); i++){
            System.out.printf("%d. %s%n%s%n%s%n%n",
                                (i+1),
                                myPhoneBook.get(i).getName(),
                                myPhoneBook.get(i).getPhoneNumber(),
                                myPhoneBook.get(i).getEmail());
        }
    }

    public Contact searchContact(){

        System.out.print("Wpisz nazwe kontaktu: ");
        String searchContact = input.nextLine();
        for(int i = 0; i < myPhoneBook.size(); i++){
            if(searchContact.equals(myPhoneBook.get(i).getName())){
               return myPhoneBook.get(i);
            }
        }
        return null;
    }

    public void addContact(){
        Contact contact = new Contact(putName(), putNumber(), putEmail());
        if(myPhoneBook.contains(contact)){
            System.out.println("Taki kontakt istnieje w twojej ksiazce telefonicznej.");
        }else {
            myPhoneBook.add(contact);
            Collections.sort(myPhoneBook);
            System.out.println("Dodano nowy kontakt: " + contact);
        }
    }

    public String putName(){
        System.out.print("Wprowadz nazwe: ");
        String name = input.nextLine();
        boolean isValid = validate.validateName(name);
        if(isValid){
            return name;
        }else{
            System.out.println("Niepoprawny format nazwy!");
            return putName();
        }
    }

    public String putNumber(){
        System.out.print("Wprowadz numer telefonu: ");
        String number = input.nextLine();
        boolean isValid = validate.validatePhone(number);
        if(isValid){
            return number;
        }else{
            System.out.println("Niepoprawny format numeru telefonu!");
            System.out.println("111-111-111");
            return putNumber();
        }
    }

    public String putEmail(){
        System.out.print("Wprowadz email: ");
        String email = input.nextLine();
        boolean isValid = validate.validateEmail(email);
        if(isValid){
            return email;
        }else{
            System.out.println("Niepoprawny format adresu email!");
            return putEmail();
        }
    }

    public void editContact(Contact contact){

        while (true) {
            System.out.print("Wpisz 1 aby edytowac nazwe, 2 aby edytowac numer telefonu, 3 aby edytowac email lub 0 aby powrocic do menu glownego: ");
            int chose = input.nextInt();
            if (chose == 1) {
                input.nextLine();
                String newName = putName();
                contact.setName(newName);
            } else if (chose == 2) {
                input.nextLine();
                String newPhoneNumber = putNumber();
                contact.setPhoneNumber(newPhoneNumber);
            } else if (chose == 3) {
                input.nextLine();
                String newEmail = putEmail();
                contact.setEmail(newEmail);
            } else {
                break;
            }
        }
    }

    public void deleteContact(Contact contact) {
        myPhoneBook.remove(contact);
        System.out.println("Usunieto kontakt.");
    }

     public void writeContactsToFile() {
         System.out.print("Wpisz scieszke i nazwe pliku txt: ");
         String path = input.nextLine();
         if(validate.validatePath(path)) {
             try (FileWriter fileWriter = new FileWriter(path)) {
                 for (int i = 0; i < myPhoneBook.size(); i++) {
                     fileWriter.write(String.format("%s%n", myPhoneBook.get(i)));
                 }
                 System.out.println("Zapisano w " + path);
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }else{
             System.out.println("Bledny format!");
             writeContactsToFile();
         }
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "myPhoneBook=" + myPhoneBook +
                '}';
    }
}

