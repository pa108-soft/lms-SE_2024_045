import model.Book;
import model.DVD;
import model.LibraryItem;
import model.Member;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<LibraryItem> items;
    private List<Member> members;

    public Library() {
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
        System.out.println("Added via addItem(LibraryItem): " + item.getTitle());
    }

    public void addItem(Book book) {
        items.add(book);
        System.out.println("Added via addItem(Book): " + book.getTitle());
    }

    public void addItem(DVD dvd) {
        items.add(dvd);
        System.out.println("Added via addItem(DVD): " + dvd.getTitle());
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void printAllLateFees(int daysLate) {
        System.out.println("--- Late fees if " + daysLate + " day(s) late ---");
        for (LibraryItem item : items) {
            // Polymorphism: item එක Book ද DVD ද යන්න මත නිවැරදි calculateLateFee ක්‍රියාත්මක වේ
            double fee = item.calculateLateFee(daysLate);
            System.out.println(item.getTitle() + ": " + fee);
        }
    }

    public void streamIfPossible(LibraryItem item) {
        if (item instanceof DVD) {
            DVD dvd = (DVD) item;
            System.out.println("Streaming \"" + dvd.getTitle() + "\" (" + dvd.getDurationMinutes() + " min)...");
        } else {
            System.out.println(item.getTitle() + " cannot be streamed it isn't a DVD.");
        }
    }
}

