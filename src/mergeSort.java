import java.util.Arrays;

public class mergeSort {

    public static <E extends Comparable<E>> void mergeSort(E[] list) {
        if (list == null || list.length <= 1) {
            return;
        }
        int mid = list.length / 2;
        E[] leftHalf = Arrays.copyOfRange(list, 0, mid);
        E[] rightHalf = Arrays.copyOfRange(list, mid, list.length);

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(list, leftHalf, rightHalf);
    }

    private static <E extends Comparable<E>> void merge(E[] list, E[] leftHalf, E[] rightHalf) {
        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = 0;

        while (leftIndex < leftHalf.length && rightIndex < rightHalf.length) {
            if (leftHalf[leftIndex].compareTo(rightHalf[rightIndex]) < 0) {
                list[mergedIndex++] = leftHalf[leftIndex++];
            } else {
                list[mergedIndex++] = rightHalf[rightIndex++];
            }
        }

        while (leftIndex < leftHalf.length) {
            list[mergedIndex++] = leftHalf[leftIndex++];
        }

        while (rightIndex < rightHalf.length) {
            list[mergedIndex++] = rightHalf[rightIndex++];
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 2, 9, 3, 6};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}



