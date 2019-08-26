package functional.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class References {
    static class ValueHolder<T> {
        private final T value;

        ValueHolder(final T value) {
            this.value = value;
        }

        T getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        // static method reference
        Function<String, Integer> p1 = s -> Integer.parseInt(s);
        Function<String, Integer> p2 = Integer::parseInt;

        // instance method reference on type
        List<String> list = Arrays.asList("a", "b", "A", "B");
        list.sort((x, y) -> x.compareToIgnoreCase(y));
        list.sort(String::compareToIgnoreCase);

        // instance method reference on object
        ValueHolder<Integer> holder = new ValueHolder<>(100);
        Supplier<Integer> s1 = () -> holder.getValue();
        Supplier<Integer> s2 = holder::getValue;

        // ctor references
        Supplier<String> sup1 = () -> new String();
        Supplier<String> sup2 = String::new;
    }
}
