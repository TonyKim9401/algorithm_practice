package programmers.codingtest;

import java.util.*;

public class Triangle {
    static class Solution {
        public int solution(int[][] triangle) {
            List<List<Integer>> cal = new ArrayList<>();
            for (int i = 0; i < triangle.length; i++) {
                cal.add(new ArrayList<>());
            }

            // 맨위 꼭대기 추가
            cal.get(0).add(triangle[0][0]);

            // 2번째줄 부터 더해가며 Max값 넣기
            for (int i = 0; i < triangle.length - 1; i++) { // 맨 마지막 줄은 채우기만 하면 됨

                int[] nextLine = triangle[i + 1]; // 다음 줄 값 3, 8 / 8, 1, 0

                List<Integer> nowList = cal.get(i);
                List<Integer> nextList = cal.get(i+1);

                // nowList와 nextLine을 조합해 nextList에 채워주기, Math.max 사용
                for (int k = 0; k < nowList.size(); k++) {
                    // 0이면 바로 더해서 내려감
                    if (k == 0) nextList.add(nowList.get(k) + nextLine[0]);
                    else {
                        // 0이 아니면 -1번째, 현재 중 어떤 값이 더 큰지 비교하여 넣음
                        int a = nowList.get(k) + nextLine[k];
                        int b = nowList.get(k-1) + nextLine[k];
                        nextList.add(Math.max(a, b));
                    }
                }
                int idx = nowList.size() - 1;
                nextList.add(nowList.get(idx) + nextLine[idx + 1]);
            }




            return Collections.max(cal.get(cal.size()-1));
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[][]{{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}});
        System.out.println(result);
    }
}
