//https://www.acmicpc.net/problem/1546

package seungtae.ch3;

import java.util.*;
import java.io.*;

public class BOJ1546_RE {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        arr = br.readLine().split(" ");

        double max = Integer.parseInt(arr[0]);
        double sum = max;
        for(int i=1; i<N; i++) {
            int k = Integer.parseInt(arr[i]);
            if(max<k) max = k;
            sum += k;
        }
        double result = sum/max*100/N;
        bw.write(String.valueOf(result));
        bw.close();
    }
}
