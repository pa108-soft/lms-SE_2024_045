package lms.model; // ඔයාගේ පැකේජ් නමට අනුව මෙය වෙනස් විය හැක

public class LibraryItem {
    private String id;
    private String title;
    private boolean isBorrowed;

    // Constructor එක (දත්ත ඇතුළත් කිරීමට)
    public LibraryItem(String id, String title) {
        this.id = id;
        setTitle(title); // validated setter පාවිච්චි කරයි
        this.isBorrowed = false; // මුලදී ණයට දී නැත
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    // Setter for title with simple validation
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

    // Default calculateLateFee නීතිය (දවසකට 10.0 ගානේ)
    public double calculateLateFee(int daysLate) {
        return daysLate * 10.0;
    }

    // toString method එක getClass().getSimpleName() පාවිච්චි කරමින්
    @Override
    public String toString() {
        return getClass().getSimpleName() + "{id='" + id + "', title='" + title + "', borrowed=" + isBorrowed + "}";
    }
}
