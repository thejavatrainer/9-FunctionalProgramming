package functional.streams;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static functional.streams.Utils.createStream;

public class Collect {
    public static void main(String[] args) {
        toList();
        toCollection();
        toMap();
        groupingBy();
        partitionBy();
        counting();
        mapping();
        joining();
        maxBy();
        summingInt();
    }

    private static void toMap() {
        Map<Integer, Integer> integerMap = createStream().map(x -> x * x).collect(Collectors.toMap(x -> (int) Math.sqrt(x), x -> x));
        System.out.println(integerMap);
    }

    private static void toList() {
        List<Integer> integers = createStream().map(x -> x * x).collect(Collectors.toList());
        System.out.println(integers);
    }

    private static void toCollection() {
        LinkedList<Integer> integers = createStream().map(x -> x * x).collect(Collectors.toCollection(LinkedList::new));
        System.out.println(integers);
    }

    private static void groupingBy() {
        Map<String, List<Integer>> evenGroup = createStream().collect(Collectors.groupingBy(x -> x % 2 == 0 ? "EVEN" : "ODD"));
        System.out.println(evenGroup);
    }

    private static void partitionBy() {
        Map<Boolean, List<Integer>> collect = createStream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println(collect);
    }

    private static void counting() {
        Long count = createStream().collect(Collectors.counting());
        System.out.println(count);
    }

    private static void mapping() {
        List<Integer> collect = createStream().collect(Collectors.mapping(x -> x * x, Collectors.toList()));
        System.out.println(collect);
    }

    private static void joining() {
        String collect = createStream().collect(Collectors.mapping(x -> x.toString(), Collectors.joining(", ")));
        System.out.println(collect);
    }

    private static void maxBy() {
        Optional<Integer> collect = createStream().collect(Collectors.maxBy((x, y) -> x.compareTo(y)));
        System.out.println(collect);
    }

    private static void summingInt() {
        Integer collect = createStream().collect(Collectors.summingInt(x -> x));
        System.out.println(collect);
    }
}
