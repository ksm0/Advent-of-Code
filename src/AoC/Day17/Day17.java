package AoC.Day17;

import java.util.ArrayList;
import java.util.List;

public class Day17 {
    public static void main(String[] args) {

        int numberOfSteps = 356;
        int currentPositionPart1 = 0;
        int currentPositionPart2 = 0;
        int valuePart2 = 0;

        List<Integer> buffer = new ArrayList<>();
        buffer.add(0);


        for (int i = 1; i < 2018; i++) {
            currentPositionPart1 = ((currentPositionPart1 + numberOfSteps) % i) + 1;
            buffer.add(currentPositionPart1, i);

        }

        System.out.println("Part 1 : " + buffer.get(currentPositionPart1 + 1));


        for (int i = 1; i < 50000000; i++) {
            currentPositionPart2 = (currentPositionPart2 + numberOfSteps) % i + 1;
            if (currentPositionPart2 == 1)
                valuePart2 = i;


        }
        System.out.println("Part 2: " + valuePart2);

    }

}
