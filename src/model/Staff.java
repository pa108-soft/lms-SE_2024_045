package model;

public class Staff extends Member {
    private static final int LIMIT = 10;

    public Staff(String memberId, String name) {
        super(memberId, name, LIMIT);
    }
}
