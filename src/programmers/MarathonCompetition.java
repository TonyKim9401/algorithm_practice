package programmers;

import java.util.HashMap;
import java.util.Map;

public class MarathonCompetition {
    static class Solution {
        public String[] solution(String[] players, String[] callings) {
            Map<String, Integer> playerMap = new HashMap<>();
            for(int i = 0; i < players.length; i++) {
                playerMap.put(players[i], i);
            }

            String front;
            String called;
            int calledIdx;
            int frontIdx;

            for (int i = 0; i < callings.length; i++) {
                called = callings[i]; // 불린놈
                calledIdx = playerMap.get(callings[i]); // 불린놈 등수
                front = players[calledIdx - 1]; // 앞에놈
                frontIdx = playerMap.get(front); // 앞에놈 등수

                playerMap.put(called, frontIdx);
                playerMap.put(front, calledIdx);

                players[frontIdx] = called;
                players[calledIdx] = front;
            }

            return players;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] result = solution.solution(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"kai", "kai", "mine", "mine"});
        for (String s : result) {
            System.out.print(s + " ");
        }

    }
}
