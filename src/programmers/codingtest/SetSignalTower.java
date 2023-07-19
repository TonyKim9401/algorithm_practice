package programmers.codingtest;

public class SetSignalTower {
    static class Solution {
        public int solution(int n, int[] stations, int w) {
            int answer = 0;

            int startIdx = 1;
            int fullCover = (w * 2) + 1;

            for(int i = 0; i < stations.length; i++) {
                int startCover = stations[i] - w <= 1 ? 1 : stations[i] - w;
                int endCover = stations[i] + w >= n ? n : stations[i] + w;

                if (startCover <= startIdx) {
                    startIdx = endCover + 1;
                    continue;
                }

                int range = startCover - startIdx;
                int x = range / fullCover;
                int y = range % fullCover;
                answer += x;
                if(y > 0) answer++;

                startIdx = endCover + 1; // 다음으로
            }

            if (startIdx < n) {
                int startCover = startIdx;
                int range = n - startCover;
                int x = range / fullCover;
                int y = range % fullCover;
                answer += x;
                if(y > 0) answer++;
            }


            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int result = solution.solution(16, new int[]{9}, 2);
        int result = solution.solution(11, new int[]{4, 11}, 1);
        System.out.println("result = " + result);
    }
}
