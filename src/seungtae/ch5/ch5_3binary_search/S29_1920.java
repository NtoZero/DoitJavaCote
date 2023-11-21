package seungtae.ch5.ch5_3binary_search;

import _problems.ch5_searching.ch5_3_binary_search.P29_1920;

import java.util.*;
import java.io.*;

public class S29_1920 implements P29_1920 {
    /*
        문제 분석 : 배열 A에서 X가 존재하는지 알아내는 프로그램 작성
            - A (10^5), M(10^5) 중 M의 수를 순회하며 A에 포함되어 있는지 여부를 출력한다.
            - 이중 for문을 사용한다면 10^10까지 나오므로 시간 제한 1초를 초과한다.
            - 이분탐색의 검색 logN을 사용한다면 -> NlogN의 시간복잡도로 해결 가능

        이분 탐색 :
            - 값을 정렬한다.
            - 중간 위치를 선택한다.
            - 중간 위치의 값보다 타깃이 적으면 왼쪽을, 크면 오른쪽을 선택한다.
            - 타깃과 중간 값이 같으면 종료한다.
     */

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 원본 배열 오름차순 정렬

        int M = Integer.parseInt(br.readLine());
        int[] targets = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++) {
            int target = targets[i];
            binarySearch(arr, target);
        }

        System.out.println(sb);
    }

    static void binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        int mid = start+end/2;
        while(start <= end) {
            if(arr[mid] == target) {
                sb.append("1\n");
                return; // break가 아닌 return으로 끝내야 한다.
            } else if (arr[mid] > target) {
                end = mid-1;
            } else { // arr[mid] < target
                start = mid+1;
            }
            mid = (start+end)/2;
        }
        sb.append("0\n");
    }
}
