package juyeon.ch3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//https://www.acmicpc.net/problem/2164
public class BOJ2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Queue<Integer> Q = new LinkedList<>();

        for( int i = 1; i<= N; i++ ) {
            Q.add(i);
        }

        while( Q.size() > 1) {
            Q.poll();
            Q.add(Q.poll());
        }

        if( Q.size() == 1) System.out.println(Q.peek());
    }
}
