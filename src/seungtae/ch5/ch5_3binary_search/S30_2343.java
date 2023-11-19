package seungtae.ch5.ch5_3binary_search;

import _problems.ch5_searching.ch5_3_binary_search.P30_2343;

import java.util.*;
import java.io.*;


public class S30_2343 implements P30_2343 {
    /*
        문제 분석:  블루레이 M개의 N개의 강의에서 강의 순서를 지켜 M개로 나눈 최소값을 구해야 함.
            단, 블루레이 크기(녹화 가능한 길이)가 최소이고 같은 크기임이 보장되어야 한다.
               => 최대한 분량 합이 균등하게 나눠진 N개의 블루레이 중 강의 값이 최대값인 것을 출력!

        주의 사항:
            순서를 보장해야 하므로 정렬을 사용할 수 없다. -> TreeSet, TreeMap은 이진 탐색 트리이므로 사용 불가능

        187p 힌트:
            강의의 길이를 바탕으로 이분 탐색을 수행하며 그 최소값을 구한다.
                1. 시작 인덱스(최소 강의 분량) : 최대 레슨 시간 (N과 M이 동일한 크기인 경우)
                2. 종료 인덱스(최대 강의 분량) : 레슨 시간의 합 (M이 1인 경우)

                => 중앙 값 크기로 모든 레슨을 저장할 수 있는지의 여부를 따져 좌우 데이터 셋으로 이분 탐색 시행, 최소값 찾기
                    - 중앙값 크기로 모든 레슨을 저장할 수 있으면 종료 인덱스 = 중앙값 -1
                    - 중앙값 크기로 모든 레슨을 저장할 수 없으면 시작 인덱스 = 중앙값 +1
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N]; // 강의 담을 배열
        int start = 0, end = 0; // start는 최대 레슨 길이, end는 레슨 길이의 합으로 초기화
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > start) start = arr[i];
            end += arr[i];
        }

        // start와 end 사이에서 이분 탐색
        // 시작 인덱스 <= 종료 인덱스 가 기준점
        while(start <= end) {
            int mid  = (start+end)/2; // 최소값 + 최대값의 중앙값
            int sum = 0; // 강의 시간 합
            int count = 0; // 현재 사용한 블루레이 개수
            // mid값으로 모든 레슨을 저장할 수 있는지 여부
            for(int i=0; i<N; i++) {
                if(sum + arr[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum = sum+arr[i];
            }
            if(sum != 0) // 탐색이 끝나서도 sum이 0이 아니면 블루레이가 1개 더 필요하므로 count를 더한다.
                count++;
            if (count > M) //count가 블루레이 개수보다 많아지면 주어진 조건으로 해결X,
                start = mid+1; //중앙값으로 해결 불가능하니 중앙값+1 갱신
            else
                end = mid-1; // 중앙값이 너무 넉넉하니 범위를 다시 좁힌다.
        }
        System.out.println(start);
    }
}
