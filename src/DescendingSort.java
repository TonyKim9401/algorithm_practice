import java.util.Arrays;
import java.util.Collections;

public class DescendingSort {
    public static long solution(long n) {
        long answer = 0;

        String[] arr = String.valueOf(n).split("");
        Arrays.sort(arr, Collections.reverseOrder());

        for(String index : arr){
            answer = (answer * 10) + Integer.parseInt(index);
        }

        /*String convert = String.valueOf(n);
        int[] intArr = new int[convert.length()];
        for(int i=0; i< convert.length(); i++){
            intArr[i] = Integer.parseInt(String.valueOf(convert.charAt(i)));
        }
        Arrays.sort(intArr);
        String[] stringArr = new String[convert.length()];
        for(int i=convert.length()-1; i >=0 ; i--){
            stringArr[i] = String.valueOf(intArr[i]);
            answer = (answer * 10) + Integer.parseInt(stringArr[i]);
        }*/



        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(118372));
    }
}
