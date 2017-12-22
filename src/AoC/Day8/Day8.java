package AoC.Day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Day8 {
    public static void main(String[] args) {

        String fileName = "resources/inputDay8.txt";
        String line;
        String decrease = "dec";
        String increase = "inc";
        int largestValue = 0;
        Map<String, Integer> registers = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {

                String[] inputArray = line.split(" ");
                String register = inputArray[0];
                String command = inputArray[1];
                int number = Integer.parseInt(inputArray[2]);
                String registerToCheck = inputArray[4];
                String condition = inputArray[5];
                int numberToCompare = Integer.parseInt(inputArray[6]);

                registers.putIfAbsent(register, 0);
                registers.putIfAbsent(registerToCheck, 0);

                boolean isConditionPassed = false;

                switch (condition) {
                    case "==":
                        isConditionPassed = registers.get(registerToCheck) == numberToCompare;
                        break;
                    case ">":
                        isConditionPassed = registers.get(registerToCheck) > numberToCompare;
                        break;
                    case ">=":
                        isConditionPassed = registers.get(registerToCheck) >= numberToCompare;
                        break;
                    case "<":
                        isConditionPassed = registers.get(registerToCheck) < numberToCompare;
                        break;
                    case "<=":
                        isConditionPassed = registers.get(registerToCheck) <= numberToCompare;
                        break;
                    case "!=":
                        isConditionPassed = registers.get(registerToCheck) != numberToCompare;
                        break;
                    default:
                        System.out.println("There is a problem with condition.");

                }
                if (isConditionPassed) {
                    if (decrease.equals(command)) {
                        registers.put(register, registers.get(register) - number);
                    } else if (increase.equals(command)) {
                        registers.put(register, registers.get(register) + number);
                    }

                }
                if (Collections.max(registers.values()) > largestValue) {
                    largestValue = Collections.max(registers.values());
                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Part 1: " + Collections.max(registers.values()));
        System.out.println("Part 2: " + largestValue);


    }
}

