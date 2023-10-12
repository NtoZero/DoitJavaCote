//https://www.acmicpc.net/problem/11720

package seungtae.ch3;

import java.util.*;
import java.io.*;

public class BOJ11720_RE {
    /*
        시간 복잡도 : O(N)
        N의 최대 모수 100
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String num = br.readLine();
        int sum = 0;
        for(int i=0; i<N; i++) {
            int k = num.charAt(i)-'0';
            sum += k;
        }
        bw.write(String.valueOf(sum));
        bw.close();
    }

}
