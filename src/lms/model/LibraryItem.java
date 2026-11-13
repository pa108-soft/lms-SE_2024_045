package lms.model;

import lms.Loanable;

public abstract class LibraryItem implements Loanable {
    private String id;
    private String title;
    private boolean isBorrowed;

    public LibraryItem(String id, String title) {
        this.id = id;
        setTitle(title);
        this.isBorrowed = false;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setTitle(String title) {
        if (title != null && !title.trim().isEmpty()) {
            this.title = title;
        } else {
            this.title = "Unknown Title";
        }
    }

    public void loan(Member member) {
        if (isBorrowed) {
            System.out.println(title + " is already on loan.");
        } else if (member.getBorrowedCount() >= member.getMaxBorrowLimit()) {
            System.out.println(member.getName() + " has reached the maximum borrow limit.");
        } else {
            isBorrowed = true;
            member.incrementBorrowedCount();
            System.out.println(title + " loaned to " + member.getName());
        }
    }

    public void returnItem() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println(title + " returned.");
        } else {
            System.out.println(title + " was not on loan.");
        }
    }
    public abstract double calculateLateFee(int daysLate);

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{id='" + id + "', title='" + title + "', borrowed=" + isBorrowed + "}";
    }
}
