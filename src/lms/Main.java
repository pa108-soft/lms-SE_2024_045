package lms;

import lms.model.Book;
import lms.model.DVD;
import lms.model.Magazine;
import lms.model.Staff;
import lms.model.Student;
import lms.service.Library;
import lms.model.Member;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book b1 = new Book("B001", "Clean Code", "Robert C. Martin");
        DVD d1 = new DVD("D001", "Introduction to Algorithms", 120);
        Magazine m1 = new Magazine("M001", "Software Weekly", 42);

        library.addItem(b1);
        library.addItem(d1);
        library.addItem(m1);

        Student student = new Student("S001", "Nadeesha Perera");
        Staff staff = new Staff("ST001", "Mr. Kasun Silva");

        library.addMember(student);
        library.addMember(staff);

        library.printAllLateFees(3);

        System.out.println("--- Loans ---");

        library.lend(b1, student);

        library.lend(b1, staff);


        library.lend(d1, staff);
        library.lend(m1, staff);

        System.out.println("--- Reservations ---");

        library.reserveIfPossible(b1, staff);

        library.reserveIfPossible(d1, staff);

        library.printMembersByActivity();
    }
}