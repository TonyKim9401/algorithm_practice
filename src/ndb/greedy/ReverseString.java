package ndb.greedy;

import java.io.*;

public class ReverseString {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int one = 0;
        int zero = 0;

        if (str.charAt(0) == '1') {
            zero += 1; // 전부 0으로 만들거면 맨 앞이 1일때 무조건 한번은 뒤집어야 함
        } else {
            one += 1;
        }

        /**
         * 앞 / 뒤를 비교해서 서로 다른데
         * 뒤가 1이면, 전부 0으로 만들어 줘야 할 때 한번 뒤집어 줘야함.
         * 뒤가 0이면, 전부 1로 만들어 줘야 할 때 한번 뒤집어 줘야함.
         */
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i+1)) {
                if(str.charAt(i+1) == '1') zero += 1;
                else one += 1;
            }
        }

        System.out.println(Math.min(zero, one));
    }
}
