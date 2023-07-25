package ndb.sort;

public class InsertSort {
    public static void main(String[] args) {


        int[] unsorted = {7,5,9,0,3,1,6,2,4,8};

        for(int i = 1; i< unsorted.length; i++) {
            for(int j = i; j > 0; j--) {
                if (unsorted[j] < unsorted[j-1]) {
                    int temp = unsorted[j];
                    unsorted[j] = unsorted[j-1];
                    unsorted[j-1] = temp;
                }
            }
        }

        for (int i : unsorted) {
            System.out.print(i + " ");
        }

    }
}
