package ndb.binarysearch;


public class HowManySpecific {
    public static void main(String[] args) {

        int x = 3;
        int[] arr = new int[]{1,1,2,2,2,2,3};

        int start = 0;
        int end = arr.length;
        int firstIdx = -1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= x){
                end = mid;
                firstIdx = mid;
            } else {
                start = mid + 1;
            }
        }

        start = 0;
        end = arr.length;
        int secondIdx = -1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= x) {
                start = mid + 1;
                secondIdx = mid;
            } else {
                end = mid;
            }
        }

        System.out.println(firstIdx + " " + secondIdx);
        int result = secondIdx - firstIdx + 1;
        if (firstIdx < 0 || secondIdx < 0) result = -1;
        System.out.println(result);
    }
}
