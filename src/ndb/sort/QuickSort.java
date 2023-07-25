package ndb.sort;

public class QuickSort {

    static void quickSortImpl(int[] target, int start, int end) {

        if (start >= end) return;
        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {

            while (left <= end && target[left] <= target[pivot]){
                left += 1;
            }
            while (right > start && target[right] >= target[pivot]){
                right -= 1;
            }
            if (left > right) {
                int temp = target[pivot];
                target[pivot] = target[right];
                target[right] = temp;
            } else {
                int temp = target[right];
                target[right] = target[left];
                target[left] = temp;
            }
            quickSortImpl(target, start, right - 1);
            quickSortImpl(target, right + 1, end);
        }

    }

    public static void main(String[] args) {

        int[] unsorted = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        quickSortImpl(unsorted, 0, unsorted.length - 1);

        for (int i : unsorted) {
            System.out.print(i + " ");
        }

    }

}
