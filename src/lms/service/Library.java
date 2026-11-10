package lms.service;

import lms.model.Book;
import lms.model.DVD;
import lms.model.LibraryItem;
import lms.model.Member;

import lms.Loanable;
import lms.Reservable;

import java.util.ArrayList;
import java.util.Collections;
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
            double fee = item.calculateLateFee(daysLate);
            System.out.println(item.getTitle() + ": " + fee);
        }
    }

    // නව මෙතඩ්: ණයට දීම (Lend)
    public void lend(Loanable thing, Member member) {
        thing.loan(member);
    }

    // නව මෙතඩ්: වෙන්කරවා ගැනීම (Reserve) - instanceof පාවිච්චි කරමින්
    public void reserveIfPossible(LibraryItem item, Member member) {
        if (item instanceof Reservable) {
            Reservable reservableItem = (Reservable) item;
            reservableItem.reserve(member);
        } else {
            System.out.println(item.getTitle() + " cannot be reserved.");
        }
    }

    // නව මෙතඩ්: සාමාජිකයින් ක්‍රියාකාරීත්වය අනුව අනුපිළිවෙලට මුද්‍රණය කිරීම
    public void printMembersByActivity() {
        System.out.println("--- Members ranked by activity ---");
        List<Member> sortedMembers = new ArrayList<>(members);
        Collections.sort(sortedMembers);
        for (Member m : sortedMembers) {
            System.out.println(m.getName() + " (" + m.getBorrowedCount() + " borrowed)");
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