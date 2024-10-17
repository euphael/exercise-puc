public class RecursiveSelectionSort {

    private static int findSmallestIndex(int[] array, int start, int smallestIndex) {
        if (start == array.length) {
            return smallestIndex;
        }
        if (array[start] < array[smallestIndex]) {
            smallestIndex = start;
        }
        return findSmallestIndex(array, start + 1, smallestIndex);
    }

    public static void sortArrayRecursively(int[] array, int start) {
        if (start >= array.length - 1) {
            return;
        }

        int smallestIndex = findSmallestIndex(array, start, start);

        if (smallestIndex != start) {
            int temp = array[start];
            array[start] = array[smallestIndex];
            array[smallestIndex] = temp;
        }
        sortArrayRecursively(array, start + 1);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = { 7, 4, 5, 1, 0, 2, 6, 3 };
        System.out.println("Original Array:");
        printArray(array);

        sortArrayRecursively(array, 0);

        System.out.println("Sorted Array:");
        printArray(array);
    }
}
