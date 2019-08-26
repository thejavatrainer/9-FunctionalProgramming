package functional.streams;

import java.util.stream.Stream;

class Utils {

    static Stream<Integer> createStream() {
        return createStream(1, 20);
    }

    static Stream<Integer> createStream(int start, int size) {
        return Stream.iterate(start, i -> ++i).limit(size);
    }

    static <T> void print(T element) {
        System.out.print(element + " ");
    }
}
