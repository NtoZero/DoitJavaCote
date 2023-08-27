package seungtae.ch4;

//20. 수 정렬하기2 (2751) : https://www.acmicpc.net/problem/2751

import java.io.*;

public class BOJ2751MergeSort {
    /*
        시간복잡도 : N의 최대 개수 10^6 => NlogN의 알고리즘을 사용하자.
        - 풀이 방식 : 병합정렬
     */

    public static int[] arr; // 정리할 배열
    public static int[] tmp; // 임시 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        tmp = new int[N+1]; // 정렬용 임시 배열

        for(int i=1; i<N+1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(1, N); //병합정렬 수행
        for(int i = 1; i < N+1; i++) {
            bw.write(arr[i]+"\n");
        }
        bw.flush();
        bw.close();

    }

    private static void mergeSort(int start, int end) {
        if(end - start < 1) return; //탈출 조건 (최소 차이가 1 이상 있어야 시작)

        int middle = start + (end - start)/2; // 중간값 구하기

        mergeSort(start, middle);
        mergeSort(middle+1, end);
        for(int i = start; i <= end; i++) { // 복사할 배열에 원본 배열 복사하기
            tmp[i] = arr[i];
        }

        int newIdx = start; // 새로운 배열에 순차적으로 복사할 인덱스
        int point1 = start;   // 포인트1 조정 (시작값)
        int point2 = middle+1; // 포인트2 조정 (중간값+1)

        // 분할된 두 그룹의 포인트가 가리키는 값을 비교해 더 작은 수를 배열에 저장, 선택 데이터 그룹의 point를 오른쪽 한 칸 이동
        while(point1 <= middle && point2 <= end) {
            if(tmp[point1] > tmp[point2]) {
                arr[newIdx] = tmp[point2];
                newIdx++;
                point2++;
            } else if(tmp[point1]<=tmp[point2]) {
                arr[newIdx] = tmp[point1];
                newIdx++;
                point1++;
            }
        }

        // 한 그룹 모두 선택된 후 남아있는 값 정리
        while(point1 <= middle) {
            arr[newIdx] = tmp[point1];
            newIdx++;
            point1++;
        }
        while(point2 <= end) {
            arr[newIdx] = tmp[point2];
            newIdx++;
            point2++;
        }
    }

}
