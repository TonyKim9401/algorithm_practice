package programmers.codingtest;

public class SetSignalTower {
    static class Solution {
        public int solution(int n, int[] stations, int w) {
            int answer = 0;

            int station = 0;
            int idx = 1;

            while(idx <= n) { // < 로 하면 맨 마지막에 남았을때 해당이 안됨
                //기존 기지국 범위                 인덱스가 해당 기지국 맨 앞에보다 크거나 같으면
                if (station < stations.length && idx >= stations[station] - w) {
                    idx = stations[station] + w + 1; //인덱스를 기지국 맨 뒤 + 1로 옮겨줌
                    station++;
                } else {
                    //새로 설치한 기지국 범위
                    answer++;
                    idx += (w * 2) + 1; //양쪽 영향 + 기지국 1칸
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int result = solution.solution(16, new int[]{9}, 2);
        int result = solution.solution(11, new int[]{2, 11}, 1);
        System.out.println("result = " + result);
    }
}
