package functional.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import static functional.streams.Utils.createStream;

public class StreamIntermediateOperations {

    public static void main(String[] args) {
//        filter();
//        map();
//        flatMap();
//        peek();
//        sorted();
    }

    private static void filter() {
        System.out.println("---- Filter");
        createStream().filter(element -> element % 2 == 0).forEach(Utils::print);
        System.out.println("----");
    }

    private static void map() {
        System.out.println("---- Map");
        createStream().map(element -> element * 2).forEach(Utils::print);
        System.out.println("----");
    }

    private static void flatMap() {
        System.out.println("---- Flat map");
        List<List<Integer>> table =
                Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(4, 5, 6),
                        Arrays.asList(7, 8, 9));
        System.out.println(table);

        table.stream().flatMap(Collection::stream).forEach(Utils::print);
        System.out.println("\n----");
    }

    private static void peek() {
        System.out.println("---- Peek");
        createStream()
             .peek(Utils::print)
             .map(element -> element * 2)
             .peek(Utils::print)
             .count();
        System.out.println("----");
    }

    private static void sorted() {
        createStream()
             .sorted(Comparator.reverseOrder())
             .forEach(Utils::print);
    }
}
