package AoC.Day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class Day4 {
    public static void main(String[] args) throws IOException {
        String fileName = "resources/inputDay4.txt";

        String nextLine;
        int part1Solution = 0;
        int part2Solution = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((nextLine = reader.readLine()) != null) {

                String[] arrayOfWords = nextLine.split("\\s");
                Set<String> setOfWords = Arrays.asList(arrayOfWords)
                                               .stream()
                                               .collect(Collectors.toSet());
                if (arrayOfWords.length == setOfWords.size())
                    part1Solution++;

                Set<String> anagrams = Arrays.asList(arrayOfWords)
                                             .stream()
                                             .map(a -> a.chars().sorted()
                                                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                                                        .toString())
                                             .collect(Collectors.toSet());
                if (arrayOfWords.length == anagrams.size())
                    part2Solution++;


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Part 1: " + part1Solution);
        System.out.println("Part 2: " + part2Solution);

    }

}

