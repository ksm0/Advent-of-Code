package AoC.Day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Day9 {
    public static void main(String[] args) {

        String fileName = "resources/inputDay9.txt";
        String line;

        boolean isGarbage = false;
        boolean isNextIgnored = false;

        int score = 0;
        int level = 0;
        int garbageCounter = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            line = reader.readLine();

            for (int i = 0; i < line.length(); i++) {
                char currentChar = line.charAt(i);

                if (isNextIgnored) {
                    isNextIgnored = false;
                } else if (currentChar == '!') {
                    isNextIgnored = true;
                } else if (currentChar == '<' && !isGarbage) {
                    isGarbage = true;
                } else if (currentChar == '>' && isGarbage) {
                    isGarbage = false;
                } else if (isGarbage) {
                    garbageCounter++;
                } else if (currentChar == '{') {
                    level++;
                } else if (currentChar == '}') {
                    score += level;
                    level--;
                }
            }
            System.out.println("Part 1 : " + score);
            System.out.println("Part 2 : " + garbageCounter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
