package AoC.Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day5 {
    public static void main(String[] args) throws FileNotFoundException {

        String fileName = "resources/inputDay5.txt";
        Scanner scanner = new Scanner(new File(fileName));
        List<Integer> lines = new ArrayList<>();

        while (scanner.hasNext()) {
            lines.add(scanner.nextInt());
        }
        scanner.close();

        int[] numbers = lines.stream().mapToInt(i -> i).toArray();
        System.out.println("Part 1: " + part1Solution(numbers));
        System.out.println("Part 2: " + part2Solution(numbers));
    }

    private static int part1Solution(int[] numbers) {
        int currentPosition = 0;
        int steps = 0;
        while (currentPosition < numbers.length && currentPosition >= 0) {
            int move = numbers[currentPosition]++;
            currentPosition += move;
            steps++;
        }
        return steps;

    }

    private static int part2Solution(int[] numbers) {
        int currentPosition = 0;
        int steps = 0;
        while (currentPosition < numbers.length && currentPosition >= 0) {
            int move = numbers[currentPosition];
            if (move >= 3)
                numbers[currentPosition]--;
            else
                numbers[currentPosition]++;

            currentPosition += move;
            steps++;
        }
        return steps;

    }
}
