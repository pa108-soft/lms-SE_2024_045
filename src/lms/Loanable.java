package lms;

import lms.model.Member;

public interface Loanable {
    void loan(Member member);
    void returnItem();
}