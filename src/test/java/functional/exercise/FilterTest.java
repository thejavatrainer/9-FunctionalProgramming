package functional.exercise;

import com.google.common.collect.Lists;
import functional.exercise.data.Author;
import functional.exercise.data.Book;
import functional.exercise.data.Genre;
import functional.exercise.lambdas.LambdaFilter;
import functional.exercise.regular.RegularFilter;
import functional.exercise.stream.StreamFilter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static functional.exercise.data.Randoms.randomAuthor;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

class FilterTest {

    @ParameterizedTest
    @MethodSource("getFilters")
    void getLongBooks(Filter filter) {
        List<Book> expected = Lists.newArrayList(
                new Book(RandomStringUtils.randomAlphabetic(10), 325, Genre.NON_FICTION, 2015, randomAuthor()),
                new Book(
                        RandomStringUtils.randomAlphabetic(10), 889, Genre.NON_FICTION, 1999, randomAuthor(), randomAuthor(), randomAuthor()));

        List<Book> testData =  Lists.newArrayList(
                new Book(RandomStringUtils.randomAlphabetic(10), 10, Genre.NOVEL, 1985, randomAuthor(), randomAuthor()),
                new Book(RandomStringUtils.randomAlphabetic(10), 295, Genre.NON_FICTION, 1977, randomAuthor()),
                new Book(RandomStringUtils.randomAlphabetic(10), 150, Genre.SHORT_NOVEL, 1935, randomAuthor()));
        testData.addAll(expected);
        Collections.shuffle(testData);

        // When
        List<Book> filtered = filter.getLongBooks(testData, 300);

        // Then
        assertThat(filtered, containsInAnyOrder(expected.toArray()));
    }

    @ParameterizedTest
    @MethodSource("getFilters")
    void getLongBooksByGenre(Filter filter) {
        // Given
        List<Book> expected = Lists.newArrayList(
                new Book(RandomStringUtils.randomAlphabetic(10), 889, Genre.NOVEL, 1999, randomAuthor(), randomAuthor()),
                new Book(RandomStringUtils.randomAlphabetic(10), 503, Genre.NOVEL, 2001, randomAuthor()));

        List<Book> testData =  Lists.newArrayList(
                new Book(RandomStringUtils.randomAlphabetic(10), 325, Genre.NON_FICTION, 2015, randomAuthor()),
                new Book(RandomStringUtils.randomAlphabetic(10), 10, Genre.NOVEL, 1985, randomAuthor(), randomAuthor()),
                new Book(RandomStringUtils.randomAlphabetic(10), 295, Genre.NON_FICTION, 1977, randomAuthor()),
                new Book(RandomStringUtils.randomAlphabetic(10), 150, Genre.SHORT_NOVEL, 1948, randomAuthor()),
                new Book(RandomStringUtils.randomAlphabetic(10), 425, Genre.NOVEL, 1935, randomAuthor()));
        testData.addAll(expected);
        Collections.shuffle(testData);

        // When
        List<Book> filtered = filter.getLongBooksByGenre(testData, 500, Genre.NOVEL);

        // Then
        assertThat(filtered, containsInAnyOrder(expected.toArray()));
    }

    @ParameterizedTest
    @MethodSource("getFilters")
    void getByAuthor(Filter filter) {
        // Given
        Author author = randomAuthor();
        List<Book> expected = Lists.newArrayList(
                new Book(RandomStringUtils.randomAlphabetic(10), 889, Genre.NOVEL, 1999, randomAuthor(), author),
                new Book(RandomStringUtils.randomAlphabetic(10), 503, Genre.NOVEL, 2001, author),
                new Book(RandomStringUtils.randomAlphabetic(10), 39, Genre.SHORT_NOVEL, 1963, randomAuthor(), author, randomAuthor()));

        List<Book> testData =  Lists.newArrayList(
                new Book(RandomStringUtils.randomAlphabetic(10), 325, Genre.NON_FICTION, 2015, randomAuthor()),
                new Book(RandomStringUtils.randomAlphabetic(10), 10, Genre.NOVEL, 1985, randomAuthor(), randomAuthor()),
                new Book(RandomStringUtils.randomAlphabetic(10), 295, Genre.NON_FICTION, 1977, randomAuthor()),
                new Book(RandomStringUtils.randomAlphabetic(10), 150, Genre.SHORT_NOVEL, 1948, randomAuthor()),
                new Book(RandomStringUtils.randomAlphabetic(10), 425, Genre.NOVEL, 1935, randomAuthor()));
        testData.addAll(expected);
        Collections.shuffle(testData);

        // When
        List<Book> filtered = filter.getBooksByAuthor(testData, author);

        // Then
        assertThat(filtered, containsInAnyOrder(expected.toArray()));
    }

    @ParameterizedTest
    @MethodSource("getFilters")
    void getByYear(Filter filter) {
        // Given
        Author author = randomAuthor();
        List<Book> expected = Lists.newArrayList(
                new Book(RandomStringUtils.randomAlphabetic(10), 889, Genre.NOVEL, 1999, randomAuthor(), author),
                new Book(RandomStringUtils.randomAlphabetic(10), 10, Genre.NOVEL, 1985, randomAuthor(), randomAuthor()),
                new Book(RandomStringUtils.randomAlphabetic(10), 39, Genre.SHORT_NOVEL, 1963, randomAuthor(), author, randomAuthor()),
                new Book(RandomStringUtils.randomAlphabetic(10), 295, Genre.NON_FICTION, 1977, randomAuthor()));

        List<Book> testData =  Lists.newArrayList(
                new Book(RandomStringUtils.randomAlphabetic(10), 325, Genre.NON_FICTION, 2015, randomAuthor()),
                new Book(RandomStringUtils.randomAlphabetic(10), 503, Genre.NOVEL, 2001, author),
                new Book(RandomStringUtils.randomAlphabetic(10), 150, Genre.SHORT_NOVEL, 1948, randomAuthor()),
                new Book(RandomStringUtils.randomAlphabetic(10), 425, Genre.NOVEL, 1935, randomAuthor()));
        testData.addAll(expected);
        Collections.shuffle(testData);

        // When
        List<Book> filtered = filter.getBooksByYear(testData, 1963, 1999);

        // Then
        assertThat(filtered, containsInAnyOrder(expected.toArray()));
    }

    private static Stream<Arguments> getFilters() {
        return Stream.of(
                Arguments.of(new RegularFilter()),
                Arguments.of(new LambdaFilter()),
                Arguments.of(new StreamFilter())
        );
    }
}
