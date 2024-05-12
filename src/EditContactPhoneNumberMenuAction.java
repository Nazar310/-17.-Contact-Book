import java.util.Scanner;

public class EditContactPhoneNumberMenuAction implements MenuAction {

    private ImMemoryContacts contacts;
    private Scanner scanner;

    public EditContactPhoneNumberMenuAction(ImMemoryContacts contacts, Scanner scanner) {
        this.contacts = contacts;
        this.scanner = scanner;
    }

    @Override
    public String getName() {
        return "Редагувати номер телефону контакту";
    }

    @Override
    public void execute() {
        System.out.println("Введіть номер контакту, якому потрібно змінити номер телефону:");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index >= 1 && index <= contacts.getAll().size()) {
            System.out.println("Введіть новий номер телефону:");
            String newPhoneNumber = scanner.nextLine();
            Contact contact = contacts.getAll().get(index - 1);
            contact.setPhoneNumber(newPhoneNumber);
            System.out.println("Номер телефону контакту успішно змінено.");
        } else {
            System.out.println("Неможливо знайти контакт з таким номером.");
        }
    }

    @Override
    public boolean closeAfter() {
        return false;
    }
}
