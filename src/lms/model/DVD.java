package lms.model;

public class DVD extends LibraryItem {
    private int durationMinutes;

    public DVD(String id, String title, int durationMinutes) {
        super(id, title);
        this.durationMinutes = durationMinutes;
    }

    public int getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(int durationMinutes) { this.durationMinutes = durationMinutes; }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 25.0;
    }
}