package juyeon.ch3;

import _problems.ch3_data_structure.ch3_3_two_pointer.P9_12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9_BOJ12891_RE implements P9_12891 {

    static int[] acgt = new int[4];
    static int[] check = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] dna = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            acgt[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < P; i++) {
            if (dna[i] == 'A') check[0]++;
            if (dna[i] == 'C') check[1]++;
            if (dna[i] == 'G') check[2]++;
            if (dna[i] == 'T') check[3]++;
        }

        int count = 0;

        if (isSatisfied()) count++;

        for (int i = 0; i < S-P; i++) {
            int j = i + P;
            if (dna[i] == 'A') check[0]--;
            if (dna[i] == 'C') check[1]--;
            if (dna[i] == 'G') check[2]--;
            if (dna[i] == 'T') check[3]--;

            if (dna[j] == 'A') check[0]++;
            if (dna[j] == 'C') check[1]++;
            if (dna[j] == 'G') check[2]++;
            if (dna[j] == 'T') check[3]++;

            if (isSatisfied()) count++;
        }

        System.out.println(count);
    }

    public static boolean isSatisfied() {
        for (int i = 0; i < 4; i++) {
            if (acgt[i] > check[i]) return false;
        }
        return true;
    }
}
