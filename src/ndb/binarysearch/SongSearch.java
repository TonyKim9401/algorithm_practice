package ndb.binarysearch;

public class SongSearch {
    static class Solution {
        public int[] solution(String[] words, String[] queries) {
            int[] answer = new int[words.length - 1];

            // 이진 탐색으로 queires의 물음표 위치 찾기

            for (int i = 0; i < queries.length; i++) {

                String str = queries[i];

                int start = 0;
                int end = str.length() - 1;
                int lastIdx = 0;
                int firstIdx = 0;
                StringBuilder sb = new StringBuilder();

                if (str.charAt(0) == '?') {
                    // 맨 앞이 ?로 시작할 경우 마지막 ?의 인덱스 찾기
                    while (start <= end) {
                        int mid = (start + end) / 2;

                        if (str.charAt(mid) == '?') {
                            start = mid + 1;
                            lastIdx = start;
                        } else {
                            end = mid - 1;
                        }

                    }
                } else {
                    // 맨앞이 문자로 시작할 경우 ?의 시작점 찾기
                    while (start <= end) {
                        int mid = (start + end) / 2;

                        if (str.charAt(mid) != '?') {
                            start = mid + 1;
                            lastIdx = start -1;
                        } else {
                            end = mid - 1;
                        }
                    }
                }

                if (str.charAt(0) == '?') {
                    for (int j = lastIdx; j < str.length(); j++) {
                        sb.append(str.charAt(j));
                    }
                } else {
                    for (int j = 0; j <= lastIdx; j++) {
                        sb.append(str.charAt(j));
                    }
                }

                String temp = sb.toString();
                int count = 0;
                if (str.charAt(0) == '?') {
                    for (int j = 0; j < words.length; j++) {
                        if (str.length() == words[j].length()) {
                            String substring = words[j].substring(lastIdx, words[j].length());
                            if (temp.equals(substring)) count += 1;
                        }
                    }
                } else {
                    for (int j = 0; j < words.length; j++) {
                        if (str.length() == words[j].length()) {
                            String substring = words[j].substring(0, lastIdx + 1);
                            if (temp.equals(substring)) count += 1;
                        }
                    }
                }

                answer[i] = count;

            }

            return answer;
        }
    }

    public static void main(String[] args) {


        Solution solution = new Solution();
        int[] result = solution.solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"},
                new String[]{"fro??", "????o", "fr???", "fro???", "pro?"});

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
