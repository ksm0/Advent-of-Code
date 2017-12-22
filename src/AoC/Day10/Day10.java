package AoC.Day10;

import java.util.stream.IntStream;

public class Day10 {
    public static void main(String[] args) {

        int currentPos = 0;
        int skipSize = 0;
        int[] numbers = IntStream.range(0, 256).toArray();
        int[] lengths = {97, 167, 54, 178, 2, 11, 209, 174, 119, 248, 254, 0, 255, 1, 64, 190};

        for (int length : lengths) {
            int[] subArray = new int[length];

            for (int i = 0; i < length; i++) {
                subArray[i] = numbers[(i + currentPos) % numbers.length];

            }
            subArray = reverseArray(subArray);

            for (int i = 0; i < length; i++) {
                numbers[(i + currentPos) % numbers.length] = subArray[i];
            }
            currentPos += length + skipSize;
            currentPos %= numbers.length;
            skipSize++;
        }

        System.out.println("Part 1: " + numbers[0] * numbers[1]);
    }

    private static int[] reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }

}
