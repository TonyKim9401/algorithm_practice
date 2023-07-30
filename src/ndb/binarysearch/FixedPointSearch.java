package ndb.binarysearch;

public class FixedPointSearch {
    public static void main(String[] args) {

        int[] arr = new int[]{-15,-6,1,3,7};
        int[] arr2 = new int[]{-15,-4,2,8,9,13,15};
        int[] arr3 = new int[]{-15,-4,3,8,9,13,15};

        System.out.println(binarySearch(arr));
        System.out.println(binarySearch(arr2));
        System.out.println(binarySearch(arr3));

    }

    public static int binarySearch(int[] arr) {
        int start = 0;
        int end = arr.length;
        int idx = -1;

        while (start <= end) {
            int mid = (start + end)/2;

            if (arr[mid] == mid) {
                idx = mid;
                break;
            } else if (arr[mid] < mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return idx;
    }
}
