package functional.exercise.stream;

import com.google.common.collect.Lists;
import functional.exercise.data.Author;
import functional.exercise.data.Book;
import functional.exercise.data.Genre;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import static functional.exercise.data.Randoms.randomAuthor;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class GroupingByAuthorCollectorTest {
    @Test
    void groupBooksByAuthors() {
        // Given
        Author author = randomAuthor();
        Author author1 = randomAuthor();
        List<Book> testData =  Lists.newArrayList(
                new Book(RandomStringUtils.randomAlphabetic(10), 889, Genre.NOVEL, 1999, randomAuthor(), author),
                new Book(RandomStringUtils.randomAlphabetic(10), 503, Genre.NOVEL, 2001, author),
                new Book(RandomStringUtils.randomAlphabetic(10), 39, Genre.SHORT_NOVEL, 1963, randomAuthor(), author, randomAuthor()),
                new Book(RandomStringUtils.randomAlphabetic(10), 325, Genre.NON_FICTION, 2015, randomAuthor()),
                new Book(RandomStringUtils.randomAlphabetic(10), 10, Genre.NOVEL, 1985, author1, randomAuthor()),
                new Book(RandomStringUtils.randomAlphabetic(10), 295, Genre.NON_FICTION, 1977, randomAuthor()),
                new Book(RandomStringUtils.randomAlphabetic(10), 150, Genre.SHORT_NOVEL, 1948, author1),
                new Book(RandomStringUtils.randomAlphabetic(10), 425, Genre.NOVEL, 1935, randomAuthor(), author1));
        Collections.shuffle(testData);

        Map<Author, Set<Book>> expectedBooksByAuthors = new HashMap<>();
        testData.forEach(book -> book.getAuthors().forEach(atr -> expectedBooksByAuthors.computeIfAbsent(atr, a -> new HashSet<>()).add(book)));
        System.out.println(expectedBooksByAuthors);

        // When
        Map<Author, Set<Book>> booksByAuthor = testData.stream().collect(new GroupingByAuthorCollector());

        // Then
        assertThat(booksByAuthor.entrySet(), equalTo(expectedBooksByAuthors.entrySet()));
    }
}