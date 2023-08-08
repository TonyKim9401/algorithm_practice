package programmers.codingtest;

import java.util.*;

public class Triangle {
    static class Solution {
        public int solution(int[][] triangle) {
            int[][] cal = new int[triangle.length][];
            for (int i = 0; i < triangle.length; i++) {
                cal[i] = new int[triangle[i].length];
            }

            // 맨위 꼭대기 추가
            cal[0][0] = triangle[0][0];

            // 2번째줄 부터 더해가며 Max값 넣기
            for (int i = 0; i < triangle.length - 1; i++) { // 맨 마지막 줄은 채우기만 하면 됨

                int[] nextLine = triangle[i + 1]; // 다음 줄 값 3, 8 / 8, 1, 0

                int[] nowList = cal[i];
                int[] nextList = cal[i+1];

                // nowList와 nextLine을 조합해 nextList에 채워주기, Math.max 사용
                for (int j = 0; j < nowList.length; j++) {
                    // 0이면 바로 더해서 내려감
                    if (j == 0) nextList[0] = nowList[j] + nextLine[0];
                    else {
                        // 0이 아니면 -1번째, 현재 중 어떤 값이 더 큰지 비교하여 넣음
                        int a = nowList[j] + nextLine[j];
                        int b = nowList[j-1] + nextLine[j];
                        nextList[j] = Math.max(a, b);
                    }
                }
                int idx = nowList.length - 1;
                nextList[idx+ 1] = nowList[idx] + nextLine[idx + 1];
                cal[i+1] = nextList;
            }

            int[] lastList = cal[cal.length -1];

            return Arrays.stream(lastList).max().getAsInt();
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[][]{{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}});
        System.out.println(result);
    }
}
