package seungtae.ch4;

import _problems.ch4.ch4_arrays.P15_2750;

import java.io.*;

public class S15_BOJ2750_RE implements P15_2750 {
    /*
        버블정렬
        - 서로 '인접'한 두 수를 swap하며 정렬된 영역을 늘려가는 정렬
        - 주의점 : 앞에서 정해진 차순을 세워서 영역을 늘릴 것인지, 뒤에서부터 늘릴 것인지 확정해야한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<N-1; i++) {
            for(int j=0; j<N-1-i; j++) { // 처음 영역부터 정렬된 영역을 하나씩 늘려 나간다.
                //swap
                if(arr[j]>arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        for(int i=0; i<N; i++) {
            bw.write(arr[i]+"\n");
        }
        bw.close();
    }
}


/*
        - 다음은 서로 인접한 수를 비교하지 않았으므로 버블정렬이라고 보기 어렵다.
        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) { // 처음 영역부터 정렬된 영역을 하나씩 늘려 나간다.
                //swap
                if(arr[i]>arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
 */