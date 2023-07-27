package ndb.greedy;

import java.util.*;
import java.io.*;

public class MulOrPlus {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int answer = 0;

        for(int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            if (answer == 0 || num == 0 || num == 1) {
                answer += num;
            } else {
                answer *= num;
            }
        }

        System.out.println(answer);

    }
}
