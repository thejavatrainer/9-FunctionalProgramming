package functional.exercise;

import functional.exercise.data.Author;
import functional.exercise.data.Book;
import functional.exercise.data.Genre;
import java.util.List;

public interface Filter {

    /**
     * Get books longer than given pages.
     */
    List<Book> getLongBooks(List<Book> books, int pages);

    /**
     * Get books from genre longer than given pages.
     */
    List<Book> getLongBooksByGenre(List<Book> books, int pages, Genre genre);

    /**
     * Get books written by the given author.
     */
    List<Book> getBooksByAuthor(List<Book> books, Author author);

    /**
     * Get books written in given year interval.
     */
    List<Book> getBooksByYear(List<Book> books, int from, int to);
}
