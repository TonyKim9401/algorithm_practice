public class TookMiddleLetter {
    public String solution(String s) {
        String answer = "";

        int middleNum = 0;
        if(s.length() % 2 == 1){
            middleNum = (int)(s.length() / 2);
            return String.valueOf(s.charAt(middleNum));
        } else {
            middleNum = (int)(s.length() / 2) -1;
            return String.valueOf(s.charAt(middleNum)) + String.valueOf(s.charAt(middleNum + 1));
        }

    }
    public static void main(String[] args) {
        TookMiddleLetter tookMiddleLetter = new TookMiddleLetter();
        String answer = tookMiddleLetter.solution("abcde");
        String answer2 = tookMiddleLetter.solution("qwer");
        System.out.println(answer);
        System.out.println(answer2);
    }
}
