package soli.ch4;

import _problems.ch4.ch4_arrays.P15_2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RE_BOJ2750 implements P15_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        for(int i = 0 ; i < N ; i ++ ) {
            A[i] = Integer.parseInt(br.readLine());
        }

        int swap = 0;

        for(int i = 0 ; i < N ; i ++) {
            for(int j = i ; j < N  ; j++) {
                if(A[i] > A[j]) {
                    swap = A[i];
                    A[i] = A[j];
                    A[j] = swap;
                }
            }
        }
        for(int result : A) {
            System.out.println(result);
        }
    }
}
