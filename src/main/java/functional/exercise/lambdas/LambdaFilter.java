package functional.exercise.lambdas;

import functional.exercise.Filter;
import functional.exercise.data.Author;
import functional.exercise.data.Book;
import functional.exercise.data.Genre;
import java.util.ArrayList;
import java.util.List;

public class LambdaFilter implements Filter {

    @FunctionalInterface
    interface BookFilter {
        boolean check(Book book);
    }

    @Override
    public List<Book> getLongBooks(final List<Book> books, final int pages) {
        BookFilter filter = book -> book.getPages() > pages;

        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (filter.check(book)) {
                result.add(book);
            }
        }

        return result;
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
