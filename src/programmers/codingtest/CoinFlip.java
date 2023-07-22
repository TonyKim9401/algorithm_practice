package programmers.codingtest;

import java.util.Arrays;

public class CoinFlip {

    static class Solution {
        public int solution(int[] coin, int k) {
            int answer = 0;

            if (coin.length == 1) return 0;

            int sum = Arrays.stream(coin).sum();

            // 전부 0이거나 길이가 0이면 뒤집을게 없음
            if (sum == 0 || coin.length == 0) return 0;

            // 전체 더한 값이 k가 아닌데, 최소한 길이가 k도 안되면 뒤집을 수가 없으므로 -1
            if (sum != k && coin.length == k) return -1;

            int toZero = flipCoins(Arrays.copyOf(coin, coin.length), k, 0);
            int toOne = flipCoins(Arrays.copyOf(coin, coin.length), k, 1);

            if (toZero != -1 && toOne != -1) {
                return Math.min(toZero, toOne);
            }

            return Math.max(toZero, toOne);
        }

        private int flipCoins(int[] arr, int k, int target) {
            int count = 0;

            for (int i = 0; i < arr.length - k + 1; i++) {
                if (arr[i] == target) continue;
                for(int j = i; j < i + k; j++) {
                    arr[j] = 1 - arr[j];
                }
                count += 1;
            }

            for (int check : arr) {
                if (check != target) count = -1;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[]{0,1,0,1,1}, 3);
//        int result = solution.solution(new int[]{0,0,1,1,0,0}, 2);
        System.out.println("result = " + result);
    }
}
