package ndb.sort;

public class HowManyX {
    public static void main(String[] args) {

        int x = 2;

        int[] arr = {1,1,2,2,2,2,3};

        int min = 0;
        int max = arr.length - 1;

        int left = 0;

        while (min < max) {
            int mid = (min + max) / 2;
            if (arr[mid] >= x) max = mid;
            else min = mid + 1;
        }


        int min2 = 0;
        int max2 = arr.length - 1;

        int right = 0;
        while (min2 < max2) {
            int mid = (min2 + max2) / 2;
            if (arr[mid] > x) max2 = mid;
            else min2 = mid + 1;
        }

        int result = (max2 - max) != 0 ? max2 - max : -1;
        System.out.println(result);

    }
}
