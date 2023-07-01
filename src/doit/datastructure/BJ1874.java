package doit.datastructure;

import java.util.*;
import java.io.*;

public class BJ1874 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arrN = new int[N];
        int number = 1;
        List<Integer> stack = new ArrayList<>();
        List<String> result = new ArrayList<>();
        boolean isCheck = true;

        for(int i = 0; i <N; i++) {
            arrN[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < arrN.length; i++) {
            int value = arrN[i];

            if(stack.size() != 0) {
                if(stack.get(stack.size() - 1) > value){
                    System.out.println("NO");
                    isCheck = false;
                    break;
                }
                if (stack.get(stack.size() - 1) == value) {
                    stack.remove(stack.get(stack.size() - 1));
                    result.add("-");
                    continue;
                }
            }
            while(number <= value){
                stack.add(number);
                if(number == value){
                    result.add("+");
                    stack.remove(stack.get(stack.size() - 1));
                    result.add("-");
                    number++;
                    break;
                }
                result.add("+");
                number++;
            }
        }

        if(isCheck) {
            for (String v : result) {
                System.out.println(v);
            }
        }

    }
}
