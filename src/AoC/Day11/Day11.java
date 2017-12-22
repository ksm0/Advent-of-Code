package AoC.Day11;

import java.io.BufferedReader;
import java.io.FileReader;


public class Day11 {
    public static void main(String[] args) throws Exception {

        int x = 0;
        int y = 0;
        int furthest = 0;
        int distance = 0;
        String fileName = "resources/inputDay11.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String input = reader.readLine();
        reader.close();

        for (String direction : input.split(",")) {
            HexagonalCoordinates hex = HexagonalCoordinates.valueOf(direction);

            x += hex.dx;
            y += hex.dy;
            distance = calculateDistance(x, y);
            furthest = distance > furthest ? distance : furthest;

        }

        System.out.println("Part 1: " + distance);
        System.out.println("Part 2: " + furthest);


    }

    private static int calculateDistance(int x, int y) {
        return (Math.abs(x) + Math.abs(y) + Math.abs(x + y)) / 2;
    }
}

