package lms;

import lms.model.Member;

public interface Reservable {
    void reserve(Member m);
    void cancelReservation();
    boolean isReserved();
}