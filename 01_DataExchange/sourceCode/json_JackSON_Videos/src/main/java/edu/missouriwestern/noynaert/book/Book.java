package edu.missouriwestern.noynaert.book;

import java.time.LocalDate;
import java.util.Arrays;

public class Book {
    private String author;
    private String title;
    private String isbn;
    private int pages;
    private LocalDate publication;
    private Publisher publisher;
    private String[] characters;
    private String libraryOfCongress;

    public Book(String author, String title, String isbn, int pages, LocalDate publication, Publisher publisher, String[] characters,String libraryOfCongress) {
        setAuthor(author);
        setTitle(title);
        setIsbn(isbn);
        setPages(pages);
        setPublication(publication);
        setPublisher(publisher);
        setCharacters(characters);
        setLibraryOfCongress(libraryOfCongress);
    }
    public Book(){
        this("--","--","--",0,LocalDate.EPOCH,new Publisher(),new String[0],"--.--");
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public LocalDate getPublication() {
        return publication;
    }

    public void setPublication(LocalDate publication) {
        this.publication = publication;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String[] getCharacters() {
        return characters;
    }

    public void setCharacters(String[] characters) {
        this.characters = characters;
    }
    public String getLibraryOfCongress(){return libraryOfCongress;}
    public void setLibraryOfCongress(String libraryOfCongress){
        this.libraryOfCongress = libraryOfCongress;
    }

    @Override
    public String toString() {
        return
                "\uD83D\uDD6E author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", pages=" + pages +
                ", publication=" + publication +
                ", publisher=" + publisher.toString() +
                ", characters=" + Arrays.toString(characters) +
                ", libraryOfCongress='" + libraryOfCongress + " \uD83D\uDD6E";
    }
}
