package model;

public class Book extends LibraryItem {
    private String author;

    public Book(String id, String title, String author) {
        super(id,title);
        setAuthor(author);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author != null && !author.trim().isEmpty()) {
            this.author = author;
        } else {
            this.author = "Unknown Author";
        }
    }
}

