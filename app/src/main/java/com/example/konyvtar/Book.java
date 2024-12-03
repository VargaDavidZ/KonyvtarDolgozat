package com.example.konyvtar;

public class Book {

    private String title;
    private String author;
    private String pageNumber;


    public Book(String title, String author, String pageNumber) {
        this.title = title;
        this.author = author;
        this.pageNumber = pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPageNumber() {
        return pageNumber;
    }



    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pageNumber=" + pageNumber +
                '}';
    }
}
