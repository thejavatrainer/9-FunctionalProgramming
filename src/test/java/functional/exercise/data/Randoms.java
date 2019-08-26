package functional.exercise.data;

import java.lang.reflect.Field;
import java.time.LocalDate;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public final class Randoms {

    private Randoms() {
    }

    public static Book randomBook() {
        return new Book(
                RandomStringUtils.randomAlphabetic(10),
                RandomUtils.nextInt(10, 1000),
                randomEnum(Genre.class),
                RandomUtils.nextInt(1800, LocalDate.now().getYear()),
                randomAuthor(),
                randomAuthor());
    }

    public static Author randomAuthor() {
        return new Author(RandomStringUtils.randomAlphabetic(10));
    }

    private static <T extends Enum> T randomEnum(Class<T> clazz) {
        try {
            Field f = clazz.getDeclaredField("$VALUES");
            f.setAccessible(true);
            T[] values = (T[]) f.get(null);
            f.setAccessible(false);
            return values[RandomUtils.nextInt(0, values.length)];
        } catch (Exception e) {
            return null;
        }
    }
}
