package ndb.binarysearch;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class SongSearch {
    static class Solution {
        public int[] solution(String[] words, String[] queries) {
            int[] answer = new int[words.length - 1];

            List<ArrayList<String>> arr = new ArrayList<>();
            List<ArrayList<String>> reversedArr = new ArrayList<>();

            for (int i = 0; i < 10001; i++) {
                arr.add(new ArrayList<>());
                reversedArr.add(new ArrayList<>());
            }

            // words 길이별로 넣고, 뒤집어서 넣고
            for (String word : words) {
                int length = word.length();
                arr.get(length).add(word);
                word = (new StringBuffer(word)).reverse().toString();
                reversedArr.get(length).add(word);
            }

            //각 리스트별로 오름차순 정렬
            for (int i = 0; i < 10001; i++) {
                Collections.sort(arr.get(i));
                Collections.sort(reversedArr.get(i));
            }

            for (String query : queries) {

                if (!query.startsWith("?")) {
                    List<String> list = arr.get(query.length());

                    String startTemp = query.replaceAll("\\?", "a");
                    int start = 0;
                    int end = list.size();
                    int startIdx = 0;

                    while (start < end) {
                        int mid = (start + end) / 2;
                        if (list.get(mid).compareTo(startTemp) >= 0) {
                            startIdx = mid;
                            end = mid;
                        }
                        else start = mid + 1;
                    }


                    String endTemp = query.replaceAll("\\?", "z");
                    int start2 = 0;
                    int end2 = list.size();
                    int endIdx = 0;

                    while (start2 < end2) {
                        int mid = (start2 + end2) / 2;
                        if (list.get(mid).compareTo(endTemp) > 0) {
                            endIdx = mid;
                            end2 = mid;
                        }
                        else start2 = mid + 1;
                    }
                    System.out.println(query + "\t" + (endIdx + " " + startIdx));

                } else {

                }

            }


            return answer;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] result = solution.solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"},
                new String[]{"fro??", "????o", "fr???", "fro???", "pro?"});

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
