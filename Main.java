import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> listNumber = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            listNumber.add(random.nextInt(1000));
        }
        System.out.println(listNumber);
        findMinMax(listNumber.stream(), Integer::compareTo, (x, a) ->
        {
                    System.out.println("min number:" + x);
                    System.out.println("Max number:" + a);
                });
        List<Integer> countNumbers = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            countNumbers.add(random.nextInt(40));
        }
        System.out.println(countNumbers);
        countNumber(countNumbers);

    }

    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T,
                                              ? super T> minMaxConsumer) {

        List<? extends T> minMax = stream.sorted().collect(Collectors.toList());
        if (minMax.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(minMax.get(0), minMax.get(minMax.size() - 1));
        }
    }

    public static void countNumber(List<Integer> countNumbers) {
        long count = countNumbers
                .stream()
                .filter(x -> x % 2 == 0).peek
                        (System.out::println).count();
        System.out.println("Количество четных числел = " + count);

    }
}