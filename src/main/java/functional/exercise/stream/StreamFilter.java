package functional.exercise.stream;

import functional.exercise.Filter;
import functional.exercise.data.Author;
import functional.exercise.data.Book;
import functional.exercise.data.Genre;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilter implements Filter {
    @Override
    public List<Book> getLongBooks(final List<Book> books, final int pages) {
        return books.stream().filter(book -> book.getPages() > pages).collect(Collectors.toList());
    }

    @Override
    public List<Book> getLongBooksByGenre(final List<Book> books, final int pages, final Genre genre) {
        // TODO implement
        return null;
    }

    @Override
    public List<Book> getBooksByAuthor(final List<Book> books, final Author author) {
        // TODO implement
        return null;
    }

    @Override
    public List<Book> getBooksByYear(final List<Book> books, final int from, final int to) {
        // TODO implement
        return null;
    }
}
