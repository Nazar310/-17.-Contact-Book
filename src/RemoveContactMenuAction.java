import java.util.Scanner;

public class RemoveContactMenuAction implements MenuAction {

    private ImMemoryContacts contacts;
    private Scanner scanner;

    public RemoveContactMenuAction(ImMemoryContacts contacts, Scanner scanner) {
        this.contacts = contacts;
        this.scanner = scanner;
    }

    @Override
    public String getName() {
        return "Видалити контакт";
    }

    @Override
    public void execute() {
        System.out.println("Введіть номер контакту, який потрібно видалити:");
        int index = scanner.nextInt();
        scanner.nextLine(); // consume newline
        if (index >= 1 && index <= contacts.getAll().size()) {
            contacts.remove(index - 1);
            System.out.println("Контакт видалено успішно.");
        } else {
            System.out.println("Неможливо знайти контакт з таким номером.");
        }
    }

    @Override
    public boolean closeAfter() {
        return false;
    }
}
