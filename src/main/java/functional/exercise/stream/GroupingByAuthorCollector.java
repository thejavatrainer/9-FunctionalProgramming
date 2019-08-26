package functional.exercise.stream;

import functional.exercise.data.Author;
import functional.exercise.data.Book;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class GroupingByAuthorCollector implements Collector<Book, Map<Author, Set<Book>>, Map<Author, Set<Book>>> {
    @Override
    public Supplier<Map<Author, Set<Book>>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<Author, Set<Book>>, Book> accumulator() {
        return (map, book) -> {
            book.getAuthors().forEach(author -> map.computeIfAbsent(author, a -> new HashSet<>()).add(book));
        };
    }

    @Override
    public BinaryOperator<Map<Author, Set<Book>>> combiner() {
        return (left, right) -> {
            right.forEach((author, books) -> {
                left.merge(author, books, (x, y) -> {
                    x.addAll(y);
                    return x;
                });
            });

            return left;
        };
    }

    @Override
    public Function<Map<Author, Set<Book>>, Map<Author, Set<Book>>> finisher() {
        return x -> x;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.IDENTITY_FINISH);
    }
}
