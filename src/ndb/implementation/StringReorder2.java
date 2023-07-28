package ndb.implementation;

import java.util.*;

public class StringReorder2 {
    public static void main(String[] args) {

//        String str = "K1KA5CB7";
        String str = "K1KA5CB7";

        int sum = 0;
        List<Character> list = new ArrayList<>();

        for(int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (temp >= '0' && temp <= '9') {
                sum += temp - '0';
                continue;
            }
            list.add(temp);
        }

        list.sort(Comparator.comparing(o -> o));

        for (Character idx : list) {
            System.out.print(idx);
        }
        System.out.print(sum != 0 ? sum : "");
    }
}
