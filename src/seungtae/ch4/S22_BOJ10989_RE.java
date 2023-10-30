package seungtae.ch4;

import _problems.ch4.ch4_arrays.P22_10989;

// https://m.blog.naver.com/adamdoha/222015268529

import java.io.*;

public class S22_BOJ10989_RE implements P22_10989 {
    /*
        시간 제한 3초, 512MB
        수의 개수 N : 10^7 , 1<= 수 <=10^4
     */

    // 10진수 기준 BucketNum 구현
    private static int BUCKET_NUM = 10;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int maxLen = maxDigitCount(arr);
        radixSort(maxLen, arr);

        for(int i=0; i<N; i++) {
            bw.write(String.valueOf(arr[i])+"\n");
        }
        bw.close();
    }

    private static void radixSort(int maxLen, int[] arr) {
        int[] output = new int[arr.length];

        // 자릿수
        int factor = 1;
        int count = 0; // 카운트

        while(count != maxLen) {
            //bucket 초기화
            int[] bucket = new int[BUCKET_NUM];

            for(int i = 0; i <arr.length; i++) {
                //일의 자리부터 시작
                bucket[(arr[i]/factor)%10]++;
            }
            for(int i=1; i<10; i++) {
                // 합 배열을 이용해 index 계산하기
                bucket[i] += bucket[i-1];
            }
            for(int i=arr.length-1; i>=0; i--) { //현재 자릿수 기준 정렬
                output[bucket[(arr[i]/factor%10)]-1] = arr[i];
                bucket[(arr[i]/factor)%10]--;
            }
            for(int i =0; i<arr.length; i++) {
                arr[i] = output[i];
            }
            factor *= 10;
            count++;
        }
    }

    // 데이터 중 가장 큰 자리수 반환
    private static int maxDigitCount(int[] arr) {
        int max = 0;
        for(int i=0; i<arr.length; i++) {
            max = Math.max(max, digitCount(arr[i]));
        }
        return max;
    }

    // 숫자의 자리수 구하기
    private static int digitCount(int num) {
        if(num==0) {
            return 1;
        }

        //log10을 하면 자리수가 나온다. log10(100) => 2
        return (int) Math.floor(Math.log10(Math.abs(num))) + 1;
    }
}

/*
    - 아래는 메모리 초과가 발생한다.
    private static void radixSort(int[] arr) {
        //10진수 버킷 생성
        Queue<Integer>[] bucket = new ArrayDeque[BUCKET_NUM];
        for(int i=0; i<BUCKET_NUM; i++) {
            bucket[i] = new ArrayDeque<>();
        }

        int maxLen = maxDigitCount(arr);
        // 각 자리수의 숫자 저장
        int digitNumber = 0;
        // 배열에 다시 저장할 때 필요한 변수
        int arrIndex = 0;

        // 자리수만큼 반복
        for(int i=0; i<maxLen; i++) {
            // 데이터의 개수만큼 반복
            for(int j=0; j<arr.length; j++) {
                digitNumber = getDigit(arr[j], i);

                bucket[digitNumber].add(arr[j]);
            }

            // 버킷에 들어간 데이터를 순서대로 꺼내 배열에 덮어씌우기
            for(int j=0; j<BUCKET_NUM; j++) {
                while(!bucket[j].isEmpty()) {
                    arr[arrIndex++] = bucket[j].remove();
                }
            }
            arrIndex = 0;
        }
    }

    // 데이터 중 가장 큰 자리수 반환
    private static int maxDigitCount(int[] arr) {
        int max = 0;
        for(int i=0; i<arr.length; i++) {
            max = Math.max(max, digitCount(arr[i]));
        }
        return max;
    }

    // 숫자의 자리수 구하기
    private static int digitCount(int num) {
        if(num==0) {
            return 1;
        }

        //log10을 하면 자리수가 나온다. log10(100) => 2
        return (int) Math.floor(Math.log10(Math.abs(num))) + 1;
    }

    // 숫자의 자리수에 해당하는 값 구하기
    // getDigit(123, 0) => 3
    // getDigit(123, 2) => 1
    private static int getDigit(int num, int index) {
        return (int) Math.floor(Math.abs(num) / Math.pow(10, index)) % 10;
    }*/
