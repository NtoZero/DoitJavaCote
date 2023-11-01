package juyeon.ch4;

import _problems.ch4.ch4_arrays.P21_1517;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q21_BOJ1517 implements P21_1517 {

    public static int[] arr, temp;

    public static void main(String[] args) throws IOException {
        // 문제는 먼 말인지 알겠는데 어떻게 접근해얄지 하나도 모르겠어서 그냥 정렬만 해봤습니다 . . . . .
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        temp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N-1);

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }

    }

    public static void mergeSort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;

            mergeSort(start, mid);
            mergeSort(mid + 1, end);

            merge(start, mid, end);
        }
    }

    public static void merge(int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }

        int pnt1 = start;
        int pnt2 = mid + 1;
        int idx = start;

        while (pnt1 <= mid && pnt2 <= end) {
            if (temp[pnt1] <= temp[pnt2]) {
                arr[idx] = temp[pnt1];
                pnt1++;
            } else {
                arr[idx] = temp[pnt2];
                pnt2++;
            }
            idx++;
        }

        while (pnt1 <= mid) {
            arr[idx] = temp[pnt1];
            pnt1++;
            idx++;
        }

        while (pnt2 <= end) {
            arr[idx] = temp[pnt2];
            pnt2++;
            idx++;
        }
    }
}
