package functional.streams;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.BinaryOperator;

import static functional.streams.Utils.createStream;

public class StreamTerminalOperation {
    public static void main(String[] args) {
//        anyMatch();
//        allMatch();
//        findAny();
//        findFirst();
//        noneMatch();
//        reduce();
    }

    private static void anyMatch() {
        boolean anyEven = createStream().anyMatch(element -> element % 2 == 0);
        System.out.println("Stream has even numbers: " + anyEven);
    }

    private static void allMatch() {
        boolean allEvent = createStream().allMatch(element -> element % 2 == 0);
        System.out.println("Stream has only even numbers: " + allEvent);
    }

    private static void findAny() {
        Optional<Integer> anyElement = createStream().findAny();
        System.out.println("Any element " + anyElement);
    }

    private static void findFirst() {
        Optional<Integer> firstElement = createStream().sorted(Comparator.reverseOrder()).findFirst();
        System.out.println("First element " + firstElement);
    }

    private static void noneMatch() {
        boolean noneMatch = createStream().noneMatch(element -> element > 100);
        System.out.println("All elements smaller that 100: " + noneMatch);
    }

    private static void reduce() {
        Integer sum = createStream().reduce(0, (x, y) -> x + y);
        System.out.println("Stream sum is: " + sum);
    }
}
