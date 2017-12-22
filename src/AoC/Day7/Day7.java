package AoC.Day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Day7 {
    public static void main(String[] args) {

        String fileName = "resources/inputDay7.txt";
        String line;
        List<String> input = new ArrayList<>();
        List<String> children = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {
                String programName = line.substring(0, line.indexOf(" "));
                input.add(programName);

                if (line.contains("->")) {
                    String child = line.substring(line.indexOf("->") + 3);
                    String[] childrenArray = child.split(", ");

                    for (String ch : childrenArray) {
                        children.add(ch);
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String programName : input) {
            if (!children.contains(programName)) {
                System.out.println("Part 1: " + programName);
            }
        }
    }

}

