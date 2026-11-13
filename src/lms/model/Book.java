package lms.model;

import lms.Reservable;

public class Book extends LibraryItem implements Reservable {
    private String author;
    private Member reservedBy;

    public Book(String id, String title, String author) {
        super(id, title);
        setAuthor(author);
        this.reservedBy = null;
    }

    public String getAuthor() { return author; }

    public void setAuthor(String author) {
        if (author != null && !author.trim().isEmpty()) {
            this.author = author;
        } else {
            this.author = "Unknown Author";
        }
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 10.0;
    }

    @Override
    public void reserve(Member m) {
        if (isReserved()) {
            System.out.println(getTitle() + " is already reserved.");
        } else {
            reservedBy = m;
            System.out.println(getTitle() + " reserved for " + m.getName());
        }
    }

    @Override
    public void cancelReservation() {
        if (isReserved()) {
            System.out.println("Reservation cancelled for " + getTitle());
            reservedBy = null;
        } else {
            System.out.println(getTitle() + " was not reserved.");
        }
    }

    @Override
    public boolean isReserved() {
        return reservedBy != null;
    }
}