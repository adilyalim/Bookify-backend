package de.htw_berlin.bookify;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private int pages;
    private int bewertung;
    private String kommentar;
    private String thumbnail;
    private String shelf;

    public Book() {
    }

    public Book(String title, String author, int pages, int bewertung, String kommentar, String thumbnail, String shelf) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.bewertung = bewertung;
        this.kommentar = kommentar;
        this.thumbnail = thumbnail;
        this.shelf = shelf;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public int getBewertung() {
        return bewertung;
    }

    public String getKommentar() {
        return kommentar;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getShelf() {
        return shelf;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setBewertung(int bewertung) {
        this.bewertung = bewertung;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }
}