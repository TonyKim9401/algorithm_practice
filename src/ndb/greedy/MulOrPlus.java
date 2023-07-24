package ndb.greedy;

public class MulOrPlus {
    public static void main(String[] args) {
        int answer = 0 ;
        String num = "02078";


        for(int i = 0; i < num.length(); i++) {
            int check = num.charAt(i) - '0';
            if (check <= 1 || answer <= 1) {
                answer += check;
                continue;
            }
            answer *= check;
        }

        System.out.println(answer);


    }
}
