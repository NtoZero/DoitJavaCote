package soli.ch6;

import _problems.ch6_greedy.P34_1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ1744 implements P34_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minusQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> plusQ = new PriorityQueue<>();

        int one = 0;
        int zero = 0;

        for(int i = 0 ; i < N ; i ++) {
            int num = Integer.parseInt(br.readLine());

            if(num > 1) {
                plusQ.add(num);
            }
            else if (num ==1) {
                one++;
            }
            else if (num == 0) {
                zero++;
            }
            else {
                minusQ.add(num);
            }
        }

        int sum = 0;

        while(plusQ.size() > 1) {
            int a = plusQ.poll();
            int b = plusQ.poll();

            sum += (a * b);
        }

        if(!plusQ.isEmpty()) {
            sum += plusQ.poll();
        }

        while (minusQ.size() > 1) {
            int a = minusQ.poll();
            int b = minusQ.poll();

            sum += (a * b);
        }
        if(!minusQ.isEmpty()) {
            if(zero==0) {
                sum += minusQ.poll();
            }
        }

        sum += one;
        System.out.println(sum);
    }
}
