package lms.model;

public class Student extends Member {
    public Student(String memberId, String name) {
        super(memberId, name, 3); // Students can borrow up to 3 items
    }
}