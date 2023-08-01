package programmers.codingtest;

import java.text.*;
import java.util.*;

public class BiweeklyTest {
    static class Solution {
        public String[] solution(String[][] booked, String[][] unbooked) throws Exception{

            int bIdx = 0;
            int uIdx = 0;

            int totalPeople = booked.length + unbooked.length;

            int standardTime = 0;
            String[] answer = new String[totalPeople];


            while (bIdx + uIdx < totalPeople){

                if (!(bIdx < booked.length)) {
                    answer[bIdx + uIdx] = unbooked[uIdx][1];
                    uIdx += 1;
                    continue;
                }

                if (!(uIdx < unbooked.length)) {
                    answer[bIdx + uIdx] = booked[bIdx][1];
                    bIdx += 1;
                    continue;
                }
                String[] bookSplit = booked[bIdx][0].split(":");
                String[] unbookSplit = unbooked[uIdx][0].split(":");
                int bookTime = (Integer.parseInt(bookSplit[0]) * 60) + Integer.parseInt(bookSplit[1]);
                int unbookTime = (Integer.parseInt(unbookSplit[0]) * 60) + Integer.parseInt(unbookSplit[1]);

                if (bookTime <= standardTime) {
                    standardTime += 10;
                    answer[bIdx + uIdx] = booked[bIdx][1];
                    bIdx += 1;
                } else if (unbookTime <= standardTime) {
                    standardTime += 10;
                    answer[bIdx + uIdx] = unbooked[uIdx][1];
                    uIdx += 1;
                } else {
                    if (bookTime <= unbookTime) {
                        standardTime = bookTime + 10;
                        answer[bIdx + uIdx] = booked[bIdx][1];
                        bIdx += 1;
                    } else {
                        standardTime = unbookTime + 10;
                        answer[bIdx + uIdx] = unbooked[uIdx][1];
                        uIdx += 1;
                    }
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) throws Exception{

        Solution solution = new Solution();
        String[] result = solution.solution(new String[][]{{"09:57", "hae"}, {"10:05", "jee"}},
                new String[][]{{"09:56", "hee"}, {"09:57", "eom"}});
//        String[] result = solution.solution(new String[][]{{"09:55", "hae"},{"10:05", "jee"}},
//                new String[][]{{"09:55", "hee"}, {"14:07", "eom"}});
        for (String s : result) {
            System.out.println(s);
        }


//        Solution2 solution2 = new Solution2();
//        int result = solution2.solution(new int[]{2,3}, new int[]{1,2,3});
//        int result = solution2.solution(new int[]{3}, new int[]{2,2,3});
//        int result = solution2.solution(new int[]{1,2,3}, new int[]{1,1});
//        int result = solution2.solution(new int[]{3}, new int[]{3,3});
//        System.out.println("result = " + result);
    }

    static class Solution2 {
        public int solution(int[] people, int[] tshirts) {
            int answer = 0;

            int idx = 0;

            Arrays.sort(people);
            Arrays.sort(tshirts);

            for (int i = 0; i < tshirts.length; i++) {
                if (people.length > idx && tshirts[i] >= people[idx]) {
                    answer += 1;
                    idx += 1;
                }
            }
            return answer;
        }
    }
}
