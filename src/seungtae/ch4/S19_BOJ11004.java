package seungtae.ch4;

//19. K번째 수 구하기(11004) : https://www.acmicpc.net/problem/11004

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S19_BOJ11004 {
    /*
        문제 풀이 :
            - 시간복잡도 : N의 최대크기 (5,000,000) => NlogN의 이하의 알고리즘으로 푸는 것이 권장된다.
            - 퀵 정렬을 이용해 풀이해보자.
                - 퀵정렬의 평균 시간복잡도 NlogN, But 최악의 상황에서 시간복잡도 N^2
            - 피봇의 위치를 중간부터 잡아야 최악의 시간복잡도에 부합될 일이 적어진다. (이미 정렬된 상태는 최대한 활용하기)
            - K번째 수를 찾는다는 점이 퀵 정렬을 사용하기 좋은 조건이라고 할 수 있다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.valueOf(st.nextToken()); // 정렬할 수의 개수 N
        int K = Integer.valueOf(st.nextToken()); // 정렬된 배열의 목적 인덱스 K

        st = new StringTokenizer(bf.readLine());
        int [] arr = new int[N];
        for (int i = 0; i <N; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        // quick정렬 구현 메서드
        quickSort(arr, 0, N-1, K-1); // 배열 arr을 퀵정렬하는데, start 인덱스는 0, end 인덱스는 N-1에서부터 시작하여 K-1 인덱스 요소를 기준으로하는 퀵정렬수행
        System.out.println(arr[K-1]);

    }

    private static void quickSort(int[] arr, int start, int end, int K) {
        if (start < end) {
            int pivot = partition(arr, start, end); // pivot을 두 그룹 경계값 기준으로 함.

            // K번째 수가 pivot 값이면 끝낸다.
            if (pivot == K) {
                return;
            }
            // K가 pivot보다 작으면 왼쪽 그룹만 정렬
            else if(K < pivot) {
                quickSort(arr, start, pivot-1, K);
            }
            // K가 pivot보다 크면 오른쪽 그룹만 정렬
            else if (K > pivot) {
                quickSort(arr, pivot+1, end, K);
            }
        }
    }

    private static int partition(int[] arr, int start, int end) {

        // start에서 1 더한 값이 end일 경우
        if(start + 1 == end) {
            // start 요소가 end 요소보다 크면 스왑
            if(arr[start] > arr[end]) swap(arr, start, end);
            return end; // 끝 인덱스 반환
        }

        // Pivot 위치는 배열의 중앙값으로.
        int pivotIdx = (start + end) / 2;
        swap(arr, start, pivotIdx); // 중앙값 pivotIdx의 요소를 첫 인덱스 요소와 스왑
        int pivot = arr[start]; // 기준이되는 pivot값

        // 다시 start와 end값 재조정 (pivot과 start가 스왑되었으므로)
        int i = start+1;
        int j = end;

        while( i <= j) {
            // pivot보다 작은 수가 나올 때까지 j--
            while(j >= start+1 && pivot < arr[j]) {
                j--;
            }
            // pivot보다 큰 수가 나올 때까지 i++
            while ( i <= end && pivot > arr[i]) {
                i++;
            }
            if (i <= j) {
                swap(arr, i++, j--);
            }
        }

        // 피벗 값을 나눠진 두 그룹의 경계값으로 저장
        arr[start] = arr[j];
        arr[j] = pivot;
        return j;

    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
