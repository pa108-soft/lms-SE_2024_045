package lms;

import lms.exception.ItemNotAvailableException;
import lms.exception.MemberNotFoundException;
import lms.model.Book;
import lms.model.DVD;
import lms.model.Magazine;
import lms.model.Staff;
import lms.model.Student;
import lms.service.Library;

public class Main {
    private static void attempt(Library library, String itemId, String memberId) {
        try {
            library.borrowItem(itemId, memberId);
        } catch (ItemNotAvailableException e) {
            System.out.println("Cannot borrow: " + e.getMessage());
        } catch (MemberNotFoundException e) {
            System.out.println("Unknown member: " + e.getMemberId());
        } finally {
            System.out.println("(attempt finished: item " + itemId + ", member " + memberId + ")");
        }
    }

    public static void main(String[] args) {
        Library library = new Library();

        Book b1 = new Book("B001", "Clean Code", "Robert C. Martin");
        DVD d1 = new DVD("D001", "Introduction to Algorithms", 120);
        Magazine m1 = new Magazine("M001", "Software Weekly", 42);
        Book b2 = new Book("B002", "Design Patterns", "Gang of Four");
        Book b3 = new Book("B003", "Refactoring", "Martin Fowler");
        Book b4 = new Book("B004", "Head First Java", "Kathy Sierra");

        library.addItem(b1);
        library.addItem(d1);
        library.addItem(m1);
        library.addItem(b2);
        library.addItem(b3);
        library.addItem(b4);

        Student student = new Student("M001", "Nadeesha Perera");
        Staff staff = new Staff("M002", "Mr. Kasun Silva");

        library.addMember(student);
        library.addMember(staff);

        // 1. Success
        System.out.println("--- 1. Success ---");
        attempt(library, "B001", "M001");

        // 2. Already on loan (checked exception)
        System.out.println("--- 2. Already on loan (checked exception) ---");
        attempt(library, "B001", "M002");

        // 3. Unknown member (unchecked exception)
        System.out.println("--- 3. Unknown member (unchecked exception) ---");
        attempt(library, "D001", "M999");

        // 4. Unknown item
        System.out.println("--- 4. Unknown item ---");
        attempt(library, "X404", "M001");

        // 5. Returning something not on loan
        System.out.println("--- 5. Returning something not on loan ---");
        try {
            library.returnItem("D001");
        } catch (ItemNotAvailableException e) {
            System.out.println("Cannot return: " + e.getMessage());
        }

        // 6. Bad data (IllegalArgumentException)
        System.out.println("--- 6. Bad data (IllegalArgumentException) ---");
        try {
            Book badBook = new Book("B999", "", "Someone");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid book: " + e.getMessage());
        }

        // 7. Student limit (Max 3 items)
        System.out.println("--- 7. Student limit ---");
        attempt(library, "D001", "M001");
        attempt(library, "M001", "M001");
        attempt(library, "B002", "M001");
        attempt(library, "B003", "M001"); // Should fail due to limit

        // 8. Return frees a slot
        System.out.println("--- 8. Return frees a slot ---");
        try {
            library.returnItem("B001");
        } catch (ItemNotAvailableException e) {
            System.out.println(e.getMessage());
        }
        attempt(library, "B004", "M001");

        // Ranking
        library.printMembersByActivity();
    }
}