package ndb.greedy;

public class MuziLive {

    static class Solution {
        public int solution(int[] food_times, long k) {

            /**
             * 효율성 망함, 정답도 맞지는 않음
             */
            int idx = 0;
            int end = food_times.length;
            int zeroCount = 0;

            for (long i = 0; i < k; i++) {

                if (food_times[idx] != 0) {
                    food_times[idx] -= 1;
                    if (food_times[idx] == 0) zeroCount += 1;
                    idx += 1;
                } else {
                    idx += 1;
                    i -= 1;
                }

                if (zeroCount == end) return -1;
                if (idx == end) idx = 0;
            }

            if (idx + 1 == end) return 0;

            return idx + 1;

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int result = solution.solution(new int[]{3, 1, 2}, 5l);
        int result = solution.solution(new int[]{3, 3, 3}, 8l);
        System.out.println(result);
    }

}
