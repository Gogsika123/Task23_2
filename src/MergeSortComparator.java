import java.util.Comparator;
import java.util.Arrays;

public class MergeSortComparator {
    public static <E> void mergeSort(E[] list, Comparator<? super E> comparator) {
        if (list == null || list.length <= 1) {
            return;
        }
        int mid = list.length / 2;
        E[] leftHalf = Arrays.copyOfRange(list, 0, mid);
        E[] rightHalf = Arrays.copyOfRange(list, mid, list.length);
        mergeSort(leftHalf, comparator);
        mergeSort(rightHalf, comparator);
        merge(list, leftHalf, rightHalf, comparator);
    }
    private static <E> void merge(E[] list, E[] leftHalf, E[] rightHalf, Comparator<? super E> comparator) {
        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = 0;
        while (leftIndex < leftHalf.length && rightIndex < rightHalf.length) {
            if (comparator.compare(leftHalf[leftIndex], rightHalf[rightIndex]) < 0) {
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
        Integer[] arr = {5, 2, 9, 1, 5, 6};
        Comparator<Integer> comparator = Integer::compareTo;
        mergeSort(arr, comparator);
        for (Integer num : arr) {
            System.out.print(num + " ");
        }
    }
}
