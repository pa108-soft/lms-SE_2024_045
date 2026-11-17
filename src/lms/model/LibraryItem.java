package lms.model;

import lms.Loanable;
import lms.exception.ItemNotAvailableException;

public abstract class LibraryItem implements Loanable {
    private String id;
    private String title;
    private boolean isBorrowed;
    private Member borrower;

    public LibraryItem(String id, String title) {
        this.id = id;
        setTitle(title);
        this.isBorrowed = false;
        this.borrower = null;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isBorrowed() { return isBorrowed; }
    public Member getBorrower() { return borrower; }

    public void setTitle(String title) {
        if (title != null && !title.trim().isEmpty()) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("Title cannot be blank");
        }
    }

    @Override
    public void loan(Member member) throws ItemNotAvailableException {
        if (isBorrowed) {
            throw new ItemNotAvailableException(title + " is already on loan.");
        }
        if (member.getBorrowedCount() >= member.getMaxBorrowLimit()) {
            throw new ItemNotAvailableException(member.getName() + " has reached the limit of " + member.getMaxBorrowLimit() + " items.");
        }
        isBorrowed = true;
        borrower = member;
        member.incrementBorrowedCount();
        System.out.println(title + " loaned to " + member.getName());
    }

    @Override
    public void returnItem() throws ItemNotAvailableException {
        if (!isBorrowed) {
            throw new ItemNotAvailableException(title + " is not on loan.");
        }
        isBorrowed = false;
        if (borrower != null) {
            borrower.decrementBorrowedCount();
            borrower = null;
        }
        System.out.println(title + " returned.");
    }

    public abstract double calculateLateFee(int daysLate);

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{id='" + id + "', title='" + title + "', borrowed=" + isBorrowed + "}";
    }
}