package lms.service;

import lms.exception.ItemNotAvailableException;
import lms.exception.MemberNotFoundException;
import lms.model.LibraryItem;
import lms.model.Member;
import lms.Loanable;
import lms.Reservable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private final List<LibraryItem> items;
    private final List<Member> members;

    public Library() {
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public Member findMember(String memberId) {
        for (Member m : members) {
            if (m.getMemberId().equals(memberId)) {
                return m;
            }
        }
        throw new MemberNotFoundException(memberId);
    }

    public LibraryItem findItem(String itemId) throws ItemNotAvailableException {
        for (LibraryItem item : items) {
            if (item.getId().equals(itemId)) {
                return item;
            }
        }
        throw new ItemNotAvailableException("No item with id " + itemId);
    }

    public void borrowItem(String itemId, String memberId) throws ItemNotAvailableException {
        LibraryItem item = findItem(itemId);
        Member member = findMember(memberId);
        lend(item, member);
    }

    public void returnItem(String itemId) throws ItemNotAvailableException {
        LibraryItem item = findItem(itemId);
        item.returnItem();
    }

    public void lend(Loanable thing, Member member) throws ItemNotAvailableException {
        thing.loan(member);
    }

    public void printMembersByActivity() {
        System.out.println("--- Members ranked by activity ---");
        List<Member> sortedMembers = new ArrayList<>(members);
        Collections.sort(sortedMembers);
        for (Member m : sortedMembers) {
            System.out.println(m.getName() + " (" + m.getBorrowedCount() + " borrowed)");
        }
    }
}