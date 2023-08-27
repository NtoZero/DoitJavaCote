package seungtae.ch4;
//21. 버블 소트 프로그램 2 (1517) : https://www.acmicpc.net/problem/1517

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1517MergeSort {
    static int[] arr, tmp; // 공유할 정적 배열
    static long result = 0; // 카운트할 변수 (int면 틀림)

    /*
        시간복잡도 : 최대 N의 크기가 5*10^5이므로, nlogn 이하의 정렬을 사용한다.
        알고리즘 : 병합정렬 (두 그룹을 병합하는 과정에 버블 정렬이 포함)
        - 이 때, 병합정렬된 배열 요소의 인덱스를 원래 인덱스와 비교하여 이동한 과정의 개수를 세면
          버블 정렬의 count를 구할 수 있다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine()); // 수의 개수 N 받기

        // 배열 생성
        arr = new int[N+1];
        tmp = new int[N+1];

        // 문자 토큰화기
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 공백을 기준으로 문자 받아 원본배열에 넣기
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }


        //병합 정렬
        mergeSort(1, N);

        // 병합 정렬 이후 원본 배열을 출력
        System.out.println(result);
    }

    private static void mergeSort(int start, int end) {
        if(end-start < 1) return; // [종료 조건] 최소 크기 차이 1 이상


        int middle = start + (end-start)/2; // 중간값 구하기

        // 두 그룹으로 분기하여 병합정렬하기
        mergeSort(start, middle);
        mergeSort(middle+1, end);

        // tmp 배열에 원본 배열을 start 인덱스부터 end 인덱스까지 복사하기
        for(int i=start; i<=end; i++) {
            tmp[i] = arr[i];
        }

        // 새롭게 정렬될 인덱스와 포인트 2개 구하기
        int newIdx = start; // start 부터 원본 정렬에 넣어야 한다.
        int point1 = start; // point1은 start에서 시작해야 한다.
        int point2 = middle+1; // point2는 중간인덱스+1부터 시작해야 한다.

        // 나눠진 두 그룹을 병합하는 과정
        // point1은 middle까지가 최대, point2는 end까지가 최대이다.
        while(point1<=middle && point2<=end) {
            if(tmp[point1]<=tmp[point2]) {
                arr[newIdx] = tmp[point1];
                newIdx++;
                point1++;
            } else if(tmp[point1]>tmp[point2]) {
                arr[newIdx] = tmp[point2];
                newIdx++;
                point2++;
                result = result + point2 - newIdx; // 뒤쪽 데이터 값이 적은 경우에 result 업데이트 (뒤쪽 데이터 값이 적을 때만 이동한 것이므로)
            }
        }

        // 여과된 것은 가장 상위 호출 스택에서 정렬된 것이므로 이후 newIdx에 넣어주면 된다.
        while(point1<=middle) {
            arr[newIdx] = tmp[point1];
            newIdx++;
            point1++;
        }
        while(point2<=end) {
            arr[newIdx] = tmp[point2];
            newIdx++;
            point2++;
        }

    }


}
