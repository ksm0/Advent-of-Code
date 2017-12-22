package AoC.Day6;

import java.util.*;
import java.util.stream.Collectors;

public class Day6 {
    public static void main(String[] args) {

        int[] array = {4, 1, 15, 12, 0, 9, 9, 5, 5, 8, 7, 3, 14, 5, 12, 3};
        //int[] array = {0,2,7,2};

        List<Integer> input = Arrays.stream(array).boxed().collect(Collectors.toList());

        Map<List<Integer>, Integer> map = new HashMap<>();


        int steps = 0;
        map.put(input, 0);

        while (true) {
            int indexOfMax = input.indexOf(Collections.max(input));
            int maxValue = input.get(indexOfMax);
            input.set(indexOfMax++, 0);

            while (maxValue != 0) {
                indexOfMax %= input.size();
                input.set(indexOfMax, input.get(indexOfMax++) + 1);
                maxValue--;
            }
            steps++;
            if (map.containsKey(input)) {
                System.out.println("Part 2 :" + (steps - map.get(input)));
                break;
            }
            map.put(input, steps);

        }
        System.out.println("Part 1 :" + steps);

    }
}