import model.Book;
import model.DVD;
import model.Staff;
import model.Student;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book b1 = new Book("B001", "Clean Code", "Robert C. Martin");
        Book b2 = new Book("B002", "Effective Java", "Joshua Bloch");
        DVD d1 = new DVD("D001", "Introduction to Algorithms", 120);

        library.addItem(b1);
        library.addItem(b2);
        library.addItem(d1);

        Student Student = new Student("S001", "Kamal");
        Staff Staff = new Staff("ST001", "Prof. Perera");

        library.addMember(Student);
        library.addMember(Staff);

        library.printAllLateFees(3);

        library.streamIfPossible(d1);
        library.streamIfPossible(b1);
    }
}
