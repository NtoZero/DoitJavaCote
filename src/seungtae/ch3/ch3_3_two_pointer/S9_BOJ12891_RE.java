package seungtae.ch3.ch3_3_two_pointer;

import problems.ch3_data_structure.ch3_3_two_pointer.P9_12891;

import java.io.*;
import java.util.StringTokenizer;

public class S9_BOJ12891_RE implements P9_12891 {
    /*
        시간 제한 2초, 메모리 제한 512MB
        부분 문자열 길이 1 <= |P| <= |S| <= 10^6
        - 시간 복잡도 : O(NlogN) 이하 권장 => 시작 인덱스와 끝 인덱스 간격이 P로 동일하다.
            => P의 간격을 유지하며 계속해서 이전 첫 번째 인덱스의 문자는 제외하고, 다음 간격의 마지막 문자는 추가하여 집계 (슬라이딩 윈도우)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        // 1. 전체 문자열 받기
        String fullPassword = br.readLine();

        // 2. 기준 문자의 개수 받기
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        // 3. 투 포인터가 간격 P를 유지하며 문자열을 자르고 count를 확인한다.
        int start_idx = 0;
        int end_idx = P-start_idx;
        int result = 0;
        // 첫 부분배열
        String subStr = fullPassword.substring(start_idx, end_idx);

        // 계수정렬용 부분배열 및 초기 계수정렬 값 계산
        int[] arr_ACGT = new int[4];
        for(int i=0; i<P; i++) {
            char ch = subStr.charAt(i);
            switch (ch) {
                case 'A':
                    arr_ACGT[0]++;
                    break;
                case 'C':
                    arr_ACGT[1]++;
                    break;
                case 'G':
                    arr_ACGT[2]++;
                    break;
                case 'T':
                    arr_ACGT[3]++;
                    break;
            }
        }
        // 조건을 만족하면 집계
        if( A <= arr_ACGT[0] && C <= arr_ACGT[1] && G <= arr_ACGT[2] && T <= arr_ACGT[3])
            result++;
        while(end_idx < S) {
            // 빠질 인덱스 start_idx 감산, 더할 인덱스 end_idx 추가 집계 (처음 end_idx는 제외되어 있었으므로)
            char minus = fullPassword.charAt(start_idx);
            char plus = fullPassword.charAt(end_idx);

            switch (minus) {
                case 'A': arr_ACGT[0]--; break;
                case 'C': arr_ACGT[1]--; break;
                case 'G': arr_ACGT[2]--; break;
                case 'T': arr_ACGT[3]--; break;
            }

            switch (plus) {
                case 'A': arr_ACGT[0]++; break;
                case 'C': arr_ACGT[1]++; break;
                case 'G': arr_ACGT[2]++; break;
                case 'T': arr_ACGT[3]++; break;
            }

            // 조건을 만족하면 집계
            if( A <= arr_ACGT[0] && C <= arr_ACGT[1] && G <= arr_ACGT[2] && T <= arr_ACGT[3])
                result++;

            // 시작 인덱스와 끝 인덱스 갱신
            start_idx++;
            end_idx++;
        }

        bw.write(String.valueOf(result));
        bw.close();

    }
}

/*
 참고 : https://www.acmicpc.net/source/55548196
 */