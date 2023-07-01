package doit.datastructure;

import java.util.*;
import java.io.*;

public class BJ1874 {
    public static void main(String[] args) throws IOException{

        /*
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
        */

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;
        StringBuffer bf = new StringBuffer();
        for(int i = 0; i < A.length; i++){
            int su = A[i];

            if( su >= num ) {
                while( su >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else {
                int n = stack.pop();
                if(n > su){
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }
        }

        if(result){
            System.out.println(bf.toString());
        }

    }
}
