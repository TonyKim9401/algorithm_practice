package ndb.implementation;

public class CompressString {
    public static void main(String[] args) {
        String s = "abcabcabcabcdededededede";
        int answer = s.length();

        for (int step = 1; step <= s.length() / 2; step ++) {
            String compressed = ""; // step 마다 압축률
            String prev = s.substring(0, step); // 간격
            int cnt = 1; // 0 ~  step 까지의 최초 횟수

            // step부터 문자열 끝까지 step 간격으로 올림
            for (int j = step; j < s.length(); j += step) {
                String sub = ""; // prev의 비교 대상,
                for (int k = j; k < j + step; k++) {
                    // k가 전체길이 보다 작을때만 실행
                    if (k < s.length()) sub += s.charAt(k);
                }
                // for문에 상관없이 prev와 새로 만든 sub를 비교해서 같으면 반복 cnt를 1 증가
                if (prev.equals(sub)) cnt += 1;
                // 같지 않다면 compressed에 prev의 일치 회수와 함께 더해줌
                else {
                    compressed += (cnt >= 2) ? cnt + prev : prev;
                    sub = ""; // sub를 초기화 하여 현재 인덱스에서 step만큼 새로운 prev를 만들어줌
                    for (int k = j; k < j + step; k++) {
                        if (k < s.length()) sub += s.charAt(k);
                    }
                    prev = sub;
                    cnt = 1;
                }
            }

            compressed += (cnt >= 2) ? cnt + prev : prev;
            answer = Math.min(answer, compressed.length());
        }

        System.out.println(answer);
    }
}
