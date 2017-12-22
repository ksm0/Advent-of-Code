package AoC.Day13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day13 {
    public static void main(String[] args) throws FileNotFoundException {

        String fileName = "input.txt";
        Scanner scanner = new Scanner(new File(fileName));
        Map<Integer, Integer> inputMap = new HashMap<>();

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] inputArray = line.split(": ");

            for (String element : inputArray) {
                inputMap.put(Integer.valueOf(inputArray[0]), Integer.valueOf(inputArray[1]));
            }

        }
        int solutionPart1 = inputMap.entrySet()
                                    .stream()
                                    .filter(x -> x.getKey() % ((x.getValue() - 1) * 2) == 0)
                                    .mapToInt(x -> x.getKey() * x.getValue())
                                    .sum();

        System.out.println("Part 1: " + solutionPart1);

    }

}
