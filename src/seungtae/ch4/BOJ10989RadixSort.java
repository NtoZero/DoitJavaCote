package seungtae.ch4;

//22. 수 정렬하기 3 (10989) : https://www.acmicpc.net/problem/10989
//[참고] 기수정렬 : https://lktprogrammer.tistory.com/48
// [다른 풀이 - 계수정렬] https://st-lab.tistory.com/107
// [다른 풀이 - 계수정렬2] https://velog.io/@lifeisbeautiful/Java-%EB%B0%B1%EC%A4%80-10989%EB%B2%88-%EC%88%98-%EC%A0%95%EB%A0%AC%ED%95%98%EA%B8%B03-%EC%9E%90%EB%B0%94
// [다른 풀이 - 삽입, 합병, 힙, 계수] https://upcurvewave.tistory.com/377

import java.io.*;
import java.util.ArrayList;
import java.util.Queue;

public class BOJ10989RadixSort {
    /*
        시간복잡도 : 10^7 => (nlogn)의 알고리즘 보다 효율적인 알고리즘이 필요
        - 기수 정렬(radix sort) 시간 복잡도 : O(kn) (이때 k는 기수의 길이, 10000 이하이므로 5)
        - k가 1부터 1만까지의 자연수이므로 계수정렬로도 풀이할 수 있다.
     */
    /*
        이건 사실 주의사항보다 특이사항인데,
        모든 값을 배열에 저장하는 기수정렬의 원래로직인 큐(LinkedLisr)를 이용해서 구현하면 메모리초과가난다.
        LinkedList를 이용했을 때 최악의 경우 사용되는 메모리가 10^7*4byte 인데,
        메모리 제한이 8MB로 8*10^6byte이므로 메모리제한을 훨씬 초과한다.
        (출처: https://velog.io/@chosj1526/%EB%B0%B1%EC%A4%80-10989-%EC%88%98-%EC%A0%95%EB%A0%AC%ED%95%98%EA%B8%B0-3)
     */

    static int[] arr; // 원본 배열
//    static ArrayList<Queue> bucket = new ArrayList<>(); //큐를 담을 어레이리스트 (단, 이 문제는 메모리 초과 때문에 큐를 이용할 수 없다.)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());

        arr = new int[N+1];

        for(int i=1; i<N+1; i++) { //0을 비워두고 1부터 받기
            arr[i] = Integer.valueOf(br.readLine());
        }
        br.close();

        //기수 정렬
        radixSort(arr, 5); // 인자(기수 정렬할 배열, 기수의 길이)

        for(int i=1; i<=N; i++) {
            bw.write(arr[i]+"\n");
        }
        bw.flush();
        bw.close();
    }

    private static void radixSort(int[] arr, int max_size) {
        int[] output = new int[arr.length]; // 원본배열의 길이만큼을 가지고 있는 배열 객체 output 생성
        int jarisu = 1; // 자릿수, 1의 자리부터 시작
        int count = 0;
        while(count != max_size) { // count가 기수길이에 도달하지 않는동안
            // 10개의 버킷 만들기
            int[] bucket = new int[10];

            for(int i=0; i< arr.length; i++) {
                bucket[(arr[i]/jarisu) % 10]++; // arr[i]의 일의 자리부터 시작
            }

            for(int i=1; i<10; i++) {   // 합 배열을 이용해 index 계산 (so, 0번 인덱스는 제외하고 시작)
                bucket[i] += bucket[i-1];
            }

            for(int i = arr.length-1; i>=0; i--) { // 현재 자릿수를 기준으로 정렬하기 (그런데 왜 역산?)
                output[bucket[(arr[i]/jarisu %10)]-1] = arr[i]; //(1을 빼주는 이유는 output배열 인덱스가 0부터 시작하기 때문)
                bucket[(arr[i]/jarisu)%10]--; // 해당 버킷의 개수 감소
            }

            for(int i=0; i<arr.length; i++) {
                //다음 자릿수를 이동하기 위해 현재 자릿수 기준 정렬 데이터 저장
                arr[i] = output[i];
            }
            jarisu = jarisu*10; // 자릿수 증가
            count++;
        }



    }


}
