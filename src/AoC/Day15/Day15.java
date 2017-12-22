package AoC.Day15;

public class Day15 {
    public static void main(String[] args) {

        int start1 = 883;
        int start2 = 879;

        System.out.println("Part 1: " + part1Solution(start1, start2));
        System.out.println("Part 2: " + part2Solution(start1, start2));

    }

    private static int part1Solution(int start1, int start2) {

        long valueA = start1;
        long valueB = start2;

        int judgeCount = 0;

        for (int i = 0; i < 40000000; i++) {

            valueA = (valueA * 16807) % 2147483647;
            valueB = (valueB * 48271) % 2147483647;
            if ((valueA & 0xFFFF) == (valueB & 0xFFFF))
                judgeCount++;

        }
        return judgeCount;

    }

    private static int part2Solution(int start1, int start2) {

        long valueA = start1;
        long valueB = start2;

        int judgeCount = 0;

        for (int i = 0; i < 5000000; i++) {
            do {
                valueA = (valueA * 16807) % 2147483647;

            } while (valueA % 4 != 0);
            do {
                valueB = (valueB * 48271) % 2147483647;

            } while (valueB % 8 != 0);


            if ((valueA & 0xFFFF) == (valueB & 0xFFFF))
                judgeCount++;

        }
        return judgeCount;

    }
}

