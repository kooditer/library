package model;

public class Book {
    private int id;
    private static int count = 0;
    private String title;
    private String author;
    private String published;
    public Genre genre;
    public Rating rating;
    private boolean out;
    private String client;

    public Book(String title, String author, String published, Genre genre, Rating rating, boolean out, String client) {
        this.title = title;
        this.author = author;
        this.published = published;
        this.genre = genre;
        this.rating = rating;
        this.out = out;
        this.client = client;
        this.id = count;
        count++;
    } //Book constructor

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }



    public boolean isOut() {
        return out;
    }

    public void setOut(boolean out) {
        this.out = out;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}//Book class end
