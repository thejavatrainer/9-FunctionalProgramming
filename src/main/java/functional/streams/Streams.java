package functional.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) throws Exception {
//        fromValues();
//        fromValuesWithBuilder();
//        iterate();
//        generate();
//        fromArray();
//        fromCollection();
//        readFile("./pom.xml");
//        listFiles(".");
    }

    private static void fromValues() {
        System.out.println("---- Stream from values");
        Stream.of(1, 2, 3, 4).forEach(System.out::println);
        System.out.println("----");
    }

    private static void fromValuesWithBuilder() {
        System.out.println("---- Stream from values with builder");
        Stream.builder().add(1).add(2).build().forEach(System.out::println);
        System.out.println("----");
    }

    private static void emptyStream() {
        Stream.empty();
    }

    private static void iterate() {
        System.out.println("---- Iterate");
        Stream.iterate(0, i -> ++i).limit(20).forEach(System.out::println);
        System.out.println("----");
    }

    private static void generate() {
        System.out.println("---- Generate");
        Stream.generate(Math::random).limit(20).forEach(System.out::println);
        System.out.println("----");
    }

    private static void fromArray() {
        System.out.println("---- Stream from array");
        Arrays.stream(new int[] {1, 2, 3, 4}).forEach(System.out::println);
        System.out.println("----");
    }

    private static void fromCollection() {
        System.out.println("---- Stream from collection");
        Collection<Integer> integers = Arrays.asList(1, 2, 3);
        integers.stream().forEach(System.out::println);
        System.out.println("----");
    }

    private static void readFile(String file) throws IOException {
        System.out.println("---- Read file");
        Path path = Paths.get(file);
        if (Files.exists(path)) {
            Files.lines(path).forEach(System.out::println);
        }
        System.out.println("----");
    }

    private static void listFiles(String directory) throws IOException {
        System.out.println("---- List directory");
        Files.walk(Paths.get(directory)).forEach(path -> System.out.println(path.toAbsolutePath()));
        System.out.println("----");
    }
}
