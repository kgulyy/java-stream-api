import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * @author Konstantin Gulyy
 */
public class Main {
    public static void main(String[] args) {
        streamCreation();
    }

    /**
     * Создание стримов
     */
    private static void streamCreation() {
        final Collection<String> collection = Arrays.asList("Petr", "Olga", "Konstantin");
        collection.forEach(System.out::println);

        final Stream<String> stream = collection.stream();
        stream.filter(s -> s.length() > 5).forEach(System.out::println);
    }
}
