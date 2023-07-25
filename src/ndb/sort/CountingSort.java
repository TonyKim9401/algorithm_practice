package ndb.sort;

import java.util.*;

public class CountingSort {
    public static void main(String[] args) {

        int[] arr = {7,5,9,0,3,1,6,2,9,1,4,8,0,5,2};

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                int count = map.get(num);
                map.put(num, count += 1);
            }
        }

        List<Integer> keyList = new ArrayList<>(map.keySet());
        keyList.sort(Comparator.naturalOrder());

        for (int key : keyList) {
            int count = map.get(key);
            for (int i = 0; i < count; i++) {
                System.out.print(key + " ");
            }
        }

    }
}
