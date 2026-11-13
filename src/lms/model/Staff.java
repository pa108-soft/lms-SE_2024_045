package lms.model;

public class Staff extends Member {
    public Staff(String memberId, String name) {
        super(memberId, name, 5); // Staff can borrow up to 5 items
    }
}