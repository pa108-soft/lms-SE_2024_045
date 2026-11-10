package model;

public class Student extends Member {
    private static final int LIMIT = 3;

    public Student(String memberId, String name) {
        super(memberId, name, LIMIT);
    }
}
