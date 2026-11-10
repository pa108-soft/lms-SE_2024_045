package model;

public class Member {
    private String memberId;
    private String name;
    private int borrowedCount;
    private int maxBorrowLimit;

    public Member(String memberId, String name, int maxBorrowLimit) {
        this.memberId = memberId;
        setName(name);
        this.borrowedCount = 0;
        this.maxBorrowLimit = maxBorrowLimit;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            this.name = "Unknown Name";
        }
    }

    public int getBorrowedCount() {
        return borrowedCount;
    }

    public int getMaxBorrowLimit() {
        return maxBorrowLimit;
    }

    public void incrementBorrowedCount() {
        if (borrowedCount < maxBorrowLimit) {
            borrowedCount++;
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{memberId='" + memberId + "', name='" + name + "', borrowed=" + borrowedCount + "/" + maxBorrowLimit + "}";
    }
}
