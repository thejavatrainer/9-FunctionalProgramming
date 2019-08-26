package functional.exercise.regular;

import functional.exercise.Filter;
import functional.exercise.data.Author;
import functional.exercise.data.Book;
import functional.exercise.data.Genre;
import java.util.ArrayList;
import java.util.List;

public class RegularFilter implements Filter {

    public List<Book> getLongBooks(List<Book> books, int pages) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getPages() > pages) {
                result.add(book);
            }
        }

        return result;
    }

    public List<Book> getLongBooksByGenre(List<Book> books, int pages, Genre genre) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getPages() > pages && genre.equals(book.getGenre())) {
                result.add(book);
            }
        }

        return result;
    }

    @Override
    public List<Book> getBooksByAuthor(final List<Book> books, final Author author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthors().contains(author)) {
                result.add(book);
            }
        }

        return result;
    }

    @Override
    public List<Book> getBooksByYear(final List<Book> books, final int from, final int to) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() >= from && book.getYear() <= to) {
                result.add(book);
            }
        }

        return result;
    }
}
