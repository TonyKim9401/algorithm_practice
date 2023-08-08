package programmers.codingtest;

import java.util.*;

public class FiveColorCandy {

    static class Solution {
        public int[] solution(String candy, int[] positions) {
            int[] answer = new int[positions.length];

            for (int i = 0; i < positions.length; i++) {
                // 비교대상 comp
                String comp = "";

                // 길이가 1이하 일경우 비교대상 없음
                if (positions[i] <= 1) {
                    answer[i] = 0;
                    continue;
                }

                comp = candy.substring(0,positions[i]);
                int count = howManyCandy(comp);
                answer[i] = count;
            }

            return answer;
        }

        private int howManyCandy(String comp) {
            int count = 0;

            String leftSide = "";
            String rightSide = "";
            // 중간을 기점으로 양사이드 차례대로 비교
            for (int i = 1; i <= comp.length() - 1; i++) {
                int end = comp.length();
                leftSide = comp.substring(0, i);
                rightSide = comp.substring(end - i, end);
                if (leftSide.equals(rightSide)) count += 1;
            }

            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        /*int[] result = solution.solution(
                "RRRRR",
                new int[]{5, 1, 3}
        );*/
        /*int[] result = solution.solution(
                "RYRYRGPRYRYRBB",
                new int[]{12, 1, 14, 7}
        );*/
        /*int[] result = solution.solution(
                "BPBRBPBRB",
                new int[]{3,6,9}
        );*/

//        String candy = "RYRYRGPRYRYRBB";
        String candy = "BPBRBPBRB";
        int[] positions = new int[]{3,6,9};

        int i = 0; // 기준 사탕 인덱스
        int[] backwardIndices = new int[candy.length()];
        for (int j = 1; j < candy.length(); j++) {
            final char ch = candy.charAt(j); // 현재 사탕

            // 현재 사탕이 기준 사탕과 다르면 같은 사탕이 나올 때 까지 이전으로 거슬러 올라감
            while (i > 0 && ch != candy.charAt(i)) {
                i = backwardIndices[i];
            }

            // 현재 사탕이 기준 사탕과 같으면 기준 사탕을 다음으로 옮김
            if (ch == candy.charAt(i)) i += 1;
            backwardIndices[j] = i;
        }

        int[] answer = new int[positions.length];
        for (int j = 0; j < positions.length; j++) {
            int count = 0;
            int k = positions[j] - 1; // 인덱스로 만들기

            // k 번째에서 잘랐을 때 반복되는 사탕의 개수 구하기
            while (backwardIndices[k] > 0) {
                k = backwardIndices[k] - 1; // 인덱스로 만들기
                if (k < 0) break;
                count++;
            }

            answer[j] = count;
        }

        for (int a : answer) {
            System.out.print(a + " ");
        }
    }

}
