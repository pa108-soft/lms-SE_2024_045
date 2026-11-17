package lms;

import lms.exception.ItemNotAvailableException;
import lms.model.Member;

public interface Loanable {
    void loan(Member member) throws ItemNotAvailableException;
    void returnItem() throws ItemNotAvailableException;
}