package AoC.Day12;

import java.io.*;
import java.util.*;

public class Day12 {
    public static void main(String[] args) throws FileNotFoundException {

        String fileName = "resources/inputDay12.txt";
        Map<Integer, List<Integer>> mapOfPrograms = new HashMap<>();
        Set<Integer> visitedPrograms = new TreeSet<>();

        Scanner scanner = new Scanner(new File(fileName));

        while (scanner.hasNext()) {

            List<Integer> programsConnectedTo = new ArrayList<>();
            String line = scanner.nextLine();
            String commaReplaced = line.replaceAll(",", "");
            String[] splitLine = commaReplaced.split(" ");
            int arrayLength = splitLine.length;

            if (arrayLength == 3)
                programsConnectedTo.add(Integer.valueOf(splitLine[2]));
            else {
                for (int i = 2; i < arrayLength; i++) {
                    programsConnectedTo.add(Integer.valueOf(splitLine[i]));
                }
            }
            mapOfPrograms.put(Integer.valueOf(splitLine[0]), programsConnectedTo);

        }
        scanner.close();

        countProgramsInGroup(mapOfPrograms, visitedPrograms, 0);
        System.out.println("Part 1: " + visitedPrograms.size());

    }

    public static void countProgramsInGroup(Map<Integer, List<Integer>> mapOfPrograms, Set<Integer> visitedPrograms, int idOfProgram) {
        for (Integer program : mapOfPrograms.get(idOfProgram)) {
            if (!visitedPrograms.contains(program)) {
                visitedPrograms.add(program);
                countProgramsInGroup(mapOfPrograms, visitedPrograms, program);
            }
        }
    }
}
