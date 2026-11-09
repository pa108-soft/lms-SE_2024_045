package model;

public class LibraryItem {
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

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public double calculateLateFee(int daysLate) {
        return daysLate * 10.0;
    }

    public String toString() {
        return getClass().getSimpleName() + "{id='" + id + "', title='" + title + "', borrowed=" + isBorrowed + "}";
    }
}
