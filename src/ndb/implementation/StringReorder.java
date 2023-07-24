package ndb.implementation;

import java.util.*;

public class StringReorder {
    public static void main(String[] args) {

//        String str = "K1KA5CB7";
        String str = "AJKDLSI142K4JSJ9D";
        char[] arr = str.toCharArray();
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        int sum = 0;

        for (char idx : arr) {
            if (idx <= '9' && idx >= '0') {
                sum += idx - '0';
                continue;
            }
            sb.append(idx);
        }

        System.out.println(sb.toString() + sum);

    }
}
