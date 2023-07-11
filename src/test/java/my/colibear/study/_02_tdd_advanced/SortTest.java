package my.colibear.study._02_tdd_advanced;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortTest {
    @Test
    public void nothing() {

    }

    @Test
    public void sorted() throws Exception {
        assertEquals(asList(1, 2), this.sort(asList(1, 2)));
        assertEquals(asList(1, 2), this.sort(asList(2, 1)));
        assertEquals(asList(1, 2, 3), this.sort(asList(1, 2, 3)));
        assertEquals(asList(1, 2, 3), this.sort(asList(2, 1, 3)));
        assertEquals(asList(1, 2, 3), this.sort(asList(2, 3, 1)));
        assertEquals(asList(1, 2, 3), this.sort(asList(3, 2, 1)));
        assertEquals(asList(1, 2, 3, 4, 4, 5, 6, 7, 8, 9), this.sort(asList(5, 4, 4, 7, 6, 9, 8, 1, 2, 3)));
    }

    private List<Integer> sort(List<Integer> list) {
        if (list.size() > 1) {
            for (int limit = list.size() - 1; limit > 0; limit--) {
                for (int firstIndex = 0; firstIndex < limit; firstIndex++) {
                    int secondIndex = firstIndex + 1;
                    if (list.get(firstIndex) > list.get(secondIndex)) {
                        int first = list.get(firstIndex);
                        int second = list.get(secondIndex);
                        list.set(firstIndex, second);
                        list.set(secondIndex, first);
                    }
                }
            }
        }
        return list;
    }

    @Test
    public void testSort() {
        assertEquals(asList(), this.sort2(asList()));
        assertEquals(asList(1), this.sort2(asList(1)));
        assertEquals(asList(1, 2), this.sort2(asList(1, 2)));
        assertEquals(asList(1, 2), this.sort2(asList(2, 1)));
        assertEquals(asList(1, 2, 3), this.sort2(asList(1, 2, 3)));
        assertEquals(asList(1, 2, 3), this.sort2(asList(2, 1, 3)));
        assertEquals(asList(1, 2, 3), this.sort2(asList(3, 2, 1)));
        assertEquals(asList(1, 2, 3), this.sort2((asList(2, 3, 1))));
        assertEquals(asList(1, 2, 3), this.sort2(asList(3, 1, 2)));
        assertEquals(asList(1, 2, 3, 4), this.sort2(asList(3, 2, 1, 4)));
        assertEquals(asList(1, 1, 3, 4), this.sort2(asList(3, 1, 1, 4)));


    }

    private List<Integer> sort2(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        if (list.size() == 0) {
            return result;
        }

        int middle = list.get(0);
        List<Integer> middles = list.stream().filter(x -> x == middle).collect(Collectors.toList());
        List<Integer> lessers = list.stream().filter(x -> x < middle).collect(Collectors.toList());
        List<Integer> greaters = list.stream().filter(x -> x > middle).collect(Collectors.toList());

        result.addAll(this.sort(lessers));
        result.addAll(middles);
        result.addAll(this.sort(greaters));

        return result;
    }


}

