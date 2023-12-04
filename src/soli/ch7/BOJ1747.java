package soli.ch7;

import _problems.ch7_integer.ch7_1_prime_number.P39_1747;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1747 implements P39_1747 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int MAX =  2000000;

        boolean[] isPrime = new boolean[MAX];

        for(int i = N ; i < isPrime.length ; i++) {
            if(isPrime[i] && isPalindrome(i)) {
                System.out.println(i);
                break;
            }
        }

    }

    // 펠리드럼수인지 황닌
    private static boolean isPalindrome(int N) {
        String numberStr = String.valueOf(N);
        int len = numberStr.length();

        for(int i = 0 ; i <= len / 2 ; i++) {
            if (numberStr.charAt(i) != numberStr.charAt(len - i - 1)) {   // 글자수가 하나 더 많음
                return false;
            }
        }
        return true;
    }

    private static boolean[] sieve(int MAX) {
        boolean[] isPrime = new boolean[MAX + 1];

        for(int i = 2; i <= Math.sqrt(MAX) ; i++) {
            isPrime[i] = true;
        }

        for(int i = 2 ; i * i <= Math.sqrt(MAX) ; i++) {
            if(isPrime[i] == true) {
                // j 배수들 다 false
                for(int j = i * i ; j <= MAX ; j+= i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }


}


/*
    public static class BOJ1747 {
        static int[] arr = new int[10000001];
        public static void main(String[] args) {
            // 초기화
            for (int i = 2; i < arr.length; i++) {
                arr[i] = i;
            }

            isPrime();

            Scanner sc = new Scanner(System.in);

            int N = sc.nextInt();

            while (true) {
                if (arr[N] != 0 && isPalindrome(N)) {
                    System.out.println(N);
                    break;
                }
                N++;
            }
        }

        public static boolean isPalindrome(int N){
            String s = String.valueOf(N);
            char[] charArray = s.toCharArray();
            int startIdx = 0;
            int endIdx = s.length() - 1;

            while (startIdx < endIdx){
                if (charArray[startIdx] != charArray[endIdx]){
                    return false;
                }
                startIdx++;
                endIdx--;
            }

            return true;
        }

        public static void isPrime(){
            for (int i = 2; i < Math.sqrt(arr.length); i++) {
                if (arr[i] == 0) continue;
                for (int j = i + i; j < arr.length; j += i) {
                    arr[j] = 0;
                }
            }
        }
    }
 */