package ru.mail.park;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Konstantin Gulyy
 */
public class Main {
    /**
     * Создание стримов
     */
    private static void streamCreation() throws IOException {
        System.out.println("*** Способы создания стримов ***");

        // Создание стрима из коллекции
        final Collection<String> collection = Arrays.asList("Petr", "Olga", "Konstantin");
        final Stream<String> streamFromCollection = collection.stream();
        streamFromCollection.filter(s -> s.length() > 7).forEach(System.out::println);

        // Создание стрима из значений
        final Stream<Character> streamFromValues = Stream.of('A', 'B', 'C');
        System.out.println(streamFromValues.anyMatch(c -> c > 'B'));

        // Создание стрима из массива
        final Integer[] array = {1, 2, 3, 4, 5};
        final Stream<Integer> streamFromArrays1 = Arrays.stream(array);
        System.out.println(streamFromArrays1.count());
        final Stream<Integer> streamFromArrays2 = Stream.of(array);
        System.out.println(streamFromArrays2.collect(Collectors.toSet()));

        // Создание стрима из файла (каждая строка в файле будет отдельным элементом в стриме)
        final Stream<String> streamFromFile = Files.lines(Paths.get(".gitignore"));
        System.out.println(streamFromFile.findFirst().isPresent());

        // Создание стрима из строки
        final IntStream streamFromString = "777".chars();
        System.out.println(streamFromString.count());

        // С помощью билдера
        final Stream<Integer> streamFromBuilder = Stream.<Integer>builder().add(1).add(2).add(3).build();
        streamFromBuilder.forEach(System.out::print);
        System.out.println();

        // Создание параллельного стрима
        final Stream<String> parallelStream = collection.parallelStream();
        System.out.println(parallelStream.collect(Collectors.toSet()));

        // Создание бесконечного стрима c помощью Stream.iterate
        final Stream<Integer> streamFromIterate = Stream.iterate(2, n -> n * n);
        System.out.println(streamFromIterate.limit(4).collect(Collectors.toList()));

        // Создание бесконечного стрима c помощью Stream.genarate
        final Stream<String> streamFromGenerate = Stream.generate(() -> "Java");
        System.out.println(streamFromGenerate.limit(2).collect(Collectors.toList()));

        // Создание пустого стрима
        final Stream<String> streamEmpty = Stream.empty();
        System.out.println(streamEmpty.collect(Collectors.toList()));
    }

    public static void main(String[] args) throws IOException {
        streamCreation();
    }
}
