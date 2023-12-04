package seungtae.ch7.integer.ch7_1_prime_number;

import _problems.ch7_integer.ch7_1_prime_number.P39_1747;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S39_1747 implements P39_1747 {
    /*
        문제 분석 : N 이상 소수인 팰린드롬 수 중에서 가장 작은 수 구하기
            - 시간 복잡도 : NlogN (10^6)
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System. in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10000001]; // N의 최댓값이 100만이다. 오해X.
        for(int i=2; i<arr.length; i++) {
            arr[i] = i;
        }
        for(int i=2; i<Math.sqrt(arr.length); i++) {
            if(arr[i]==0) continue; // 소수가 아니면 건너 뛰기
            for(int j=i+i; j<arr.length; j=j+i) { // j는 i의 배수. 소수 X
                arr[j] = 0;
            }
        }
        for(int i=N; i<arr.length; i++) {
            if(arr[i] !=0 && func(arr[i])) { // 소수이면서 펠린드롬 수이면 출력 후 종료
                System.out.println(arr[i]);
                break;
            }
        }
    }

    // 펠린드롬 (뒤집어도 같은 숫자)
    public static boolean func(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int start = 0;
        int end = chars.length-1;
        while(start<end) {
            if(chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
