package programmers.codingtest;

import java.util.*;

public class RequestSubjects {
    static class Solution {
        String[] answer;
        Queue<String> q = new LinkedList<>();
        List<String> result = new ArrayList<>();

        public String[] solution(String[] s1, String[] s2, String k) {

            bfs(s1, s2, k);

            for (String str : result) {
                System.out.print(str + " ");
            }

            return answer;
        }

        public void bfs(String[] s1, String[] s2, String k) {
            for (int i = 0; i < s2.length; i++) {
                if (s2[i].equals(k)) {
                    q.offer(s1[i]);
                }
            }

            while (!q.isEmpty()) {
                String str = q.poll();
                if (!result.contains(str)) result.add(str);
                for (int i = 0; i < s2.length; i++) {
                    if (s2[i].equals(str)) {
                        q.offer(s1[i]);
                    }
                }
            }
        }
    }
}
