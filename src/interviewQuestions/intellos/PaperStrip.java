package interviewQuestions.intellos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PaperStrip {

    public static void main(String[] args) {
        int[] original = new int[] { 1, 4, 3, 2 };
        int[] desired = new int[] { 1, 2, 4, 3 };
        System.out.println(PaperStrip.minPieces(original, desired));
    }

    public static int minPieces(int[] original, int[] desired) {
        // Create a HashMap to store the index of each number in the original array
        Map<Integer, Integer> originalIndices = new HashMap<>();

        // Populate the HashMap with indices of numbers in the original array
        for (int i = 0; i < original.length; i++) {
            originalIndices.put(original[i], i);
        }

        // Variable to store the number of cut pieces
        int cutPieces = 0;

        // Iterate through the desired array
        for (int originalIndex = 0; originalIndex < desired.length; originalIndex++) {
            // If the number in the original array is not at its desired position
            if (original[originalIndex] != desired[originalIndex]) {
                // Find the index of the current desired number in the original array
                int desiredIndex = originalIndices.get(desired[originalIndex]);

                // Move j until it points to the first number that is in the correct position
                while (desiredIndex < desired.length && original[desiredIndex] == desired[desiredIndex]) {
                    desiredIndex++;
                }

                // Increment the number of cut pieces
                cutPieces++;

                // Print the current state of the arrays
                System.out.println("Iteration " + cutPieces + ":");
                System.out.println("Original array: " + Arrays.toString(original));
                System.out.println("Desired array: " + Arrays.toString(desired));
                System.out.println("Swapping " + original[originalIndex] + " at index " + originalIndex + " with " + original[desiredIndex] + " at index " + desiredIndex);

                // Swap the numbers to put the current number in the desired position
                swap(original, originalIndex, desiredIndex);

                // Print the updated arrays after the swap
                System.out.println("Arrays after swapping:");
                System.out.println("Original array: " + Arrays.toString(original));
                System.out.println("Desired array: " + Arrays.toString(desired));
                System.out.println();
            }
        }

        // Return the minimum number of cut pieces needed
        return cutPieces;
        }

    private static void swap(int[] original, int i, int j) {
        int temp = original[i];
        original[i] = original[j];
        original[j] = temp;
    }
}

