package functional;

import java.util.Optional;

public class Optionals {
    public static void main(String[] args) {
        Optional emptyOptional = Optional.empty();

        Optional<Integer> optional1 = Optional.of(1);
        Optional<Integer> optional2 = Optional.ofNullable(2);

        System.out.println(emptyOptional.isPresent());                              // false - optional is empty
        System.out.println(optional1.isPresent());                                  // true - optional has value
        System.out.println(optional1.get());                                        // 1 - the optional value
        optional1.ifPresent(integer -> System.out.println(integer));                // 1 - the optional value
        optional2.map(integer -> integer * integer).ifPresent(System.out::println); // 4 -

        emptyOptional.get();                                                        // throws NoSuchElementException since optional is empty
    }
}
