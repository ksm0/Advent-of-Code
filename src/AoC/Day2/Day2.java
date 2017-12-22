package AoC.Day2;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Day2 {
    public static void main(String[] args) throws Exception {

        String fileName = "resources/inputDay2.txt";

        Scanner scanner = new Scanner(new File(fileName));
        Scanner scanner2 = new Scanner(new File(fileName));

        System.out.println("Part 1: ");
        part1(scanner);
        System.out.println("Part 2: ");
        part2(scanner2);

        scanner.close();
        scanner2.close();

    }

    private static void part1(Scanner scanner) {
        int sum = 0;

        while (scanner.hasNext()) {

            String nextLine = scanner.nextLine();
            TreeSet<Integer> elements = Arrays.asList(nextLine.split("\\W")) //non word character
                                              .stream()
                                              .map(Integer::parseInt)
                                              .collect(Collectors.toCollection(TreeSet::new));
            sum += elements.last() - elements.first();

        }
        System.out.println(sum);
    }

    private static void part2(Scanner scanner) {
        int sum = 0;

        while (scanner.hasNext()) {

            String nextLine = scanner.nextLine();
            List<Integer> elements = Arrays.asList(nextLine.split("\\W"))
                                           .stream()
                                           .map(Integer::parseInt)
                                           .collect(Collectors.toList());

            for (int i = 0; i < elements.size(); i++) {
                for (int j = i + 1; j < elements.size(); j++) {
                    if (elements.get(i) > elements.get(j) && elements.get(i) % elements.get(j) == 0) {
                        sum += elements.get(i) / elements.get(j);
                    } else if (elements.get(i) < elements.get(j) && elements.get(j) % elements.get(i) == 0) {
                        sum += elements.get(j) / elements.get(i);
                    }

                }
            }

        }
        System.out.println(sum);
    }
}
