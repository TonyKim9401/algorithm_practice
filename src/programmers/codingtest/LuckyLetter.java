package programmers.codingtest;

import java.util.*;

public class LuckyLetter {

    static class Citizen {
        boolean isBadBoy;
        int letters = 0; // 최소 0개의 편지를 가지고 있으므로 초기화
        List<Integer> sendTo = new ArrayList<>(); // 누구누구에게 보내는지 저장
        Citizen(boolean b) {
            isBadBoy = b;
        }
    }
    static class Solution {
        public int solution(int n, int c, int k, int[][] contact) {
            int answer = 0;

            List<Citizen> people = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                // 악동클럽 회원수 만큼 true로 저장
                people.add(new Citizen(i < c));
            }

            // 시민들에게 연락처 저장
            for (int[] cont : contact) {
                int idx = cont[0];
                // 1부터 시작하는 인덱스를 0으로 맞추려고 1씩 뺌
                people.get(idx - 1).sendTo.add(cont[1] - 1);
            }

            // Queue에 악동클럽(및 편지를 보낼 사람) 저장
            Queue<Citizen> q = new LinkedList<>();
            for (Citizen person : people) {
                if (person.isBadBoy) q.offer(person);
            }

            // 보낼 사람이 없으면 종료
            while (!q.isEmpty()) {
                // q에서 편지를 보낼 사람 꺼내옴
                Citizen sender = q.poll();

                List<Integer> peopleIdx = sender.sendTo;
                for (Integer idx : peopleIdx) {
                    Citizen receiver = people.get(idx);
                    if (receiver.letters >= k) continue;
                    receiver.letters += 1;
                    if (receiver.letters == k) q.offer(receiver);
                }
            }

            for (Citizen person : people) {
                if (person.isBadBoy) continue;
                if (person.letters == 0) answer += 1;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        /*int result = solution.solution(
                8, 3, 2,
                new int[][]{{1,4}, {2,4}, {3,4},
                        {2,6,},{4,6},{4,5},{6,5}
                        ,{6,7},{5,7},{7,8}}
        );*/
        int result = solution.solution(
                8, 3, 2,
                new int[][]{
                        {1,4},{2,4},{3,4},
                        {4,6},{4,5},{6,5}
                        ,{6,7},{5,7},{7,8}
                }
        );
        System.out.println(result);
    }
}
