package ndb.sort;

public class SelectSort {
    public static void main(String[] args) {

        int[] unsorted = {1,9,0,2,8,3,7,4,6,5};

        int idx = 0;
        int change = 0;
        for(int i = 0; i < unsorted.length; i++) {
            idx = i;
            for(int j = i; j < unsorted.length; j++) {
                if (unsorted[idx] > unsorted[j]) {
                    idx = j;
                }
            }
            change = unsorted[i];
            unsorted[i] = unsorted[idx];
            unsorted[idx] = change;
        }

        for (int i : unsorted) {
            System.out.print(i);
        }
    }
}
