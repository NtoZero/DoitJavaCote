package soli.ch4;

import _problems.ch4.ch4_arrays.P17_1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class RE_BOJ1427 implements P17_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arr = br.readLine();

        ArrayList<Integer> A = new ArrayList<>();
        int i = 0;
        for(char c : arr.toCharArray()) {
            A.add(c - '0');
        }

        Collections.sort(A, Collections.reverseOrder());

        for(int num : A) {
            System.out.print(num);
        }

    }


}
