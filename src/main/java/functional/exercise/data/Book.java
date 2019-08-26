package functional.exercise.data;

import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Book {
    private List<Author> authors;
    private String title;
    private int pages;
    private Genre genre;
    private int year;

    public Book(final String title, final int pages, final Genre genre, final int year, Author author, Author... authors) {
        this.title = title;
        this.pages = pages;
        this.genre = genre;
        this.year = year;

        this.authors = authors == null ? Collections.singletonList(author) : Lists.asList(author, authors);
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return pages == book.pages &&
                year == book.year &&
                Objects.equals(authors, book.authors) &&
                Objects.equals(title, book.title) &&
                genre == book.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(authors, title, pages, genre, year);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
                .add("title='" + title + "'")
                .add("authors=" + authors)
                .add("pages=" + pages)
                .add("genre=" + genre)
                .add("year=" + year)
                .toString();
    }
}
