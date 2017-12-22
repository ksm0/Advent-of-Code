package AoC.Day1;

import java.io.BufferedReader;
import java.io.FileReader;


public class Day1 {
    public static void main(String[] args) throws Exception {
        String fileName = "resources/inputDay1.txt";

        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String lines = bufferedReader.readLine();

        bufferedReader.close();


        int offsetPart1 = 1;
        int offsetPart2 = lines.length() / 2;

        int part1 = calculate(lines, offsetPart1);
        int part2 = calculate(lines, offsetPart2);
        System.out.println("Part 1: " + part1);
        System.out.println("Part 2: " + part2);


    }

    private static int calculate(String input, int offset) {
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == input.charAt((i + offset) % input.length())) {
                sum += input.charAt(i) - '0';

            }

        }
        return sum;
    }


}
