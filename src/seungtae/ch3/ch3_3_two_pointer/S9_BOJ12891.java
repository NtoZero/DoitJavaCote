package seungtae.ch3.ch3_3_two_pointer;

import problems.ch3_data_structure.ch3_3_two_pointer.P9_12891;

import java.util.Scanner;

public class S9_BOJ12891 implements P9_12891 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt(); // 문자열의 총 문자 개수
        int P = sc.nextInt(); // 부분구간의 수

        sc.nextLine();
        String Dna = sc.nextLine();


        int Anum = sc.nextInt();
        int Cnum = sc.nextInt();
        int Gnum = sc.nextInt();
        int Tnum = sc.nextInt();

        /*투포인터 -> 슬라이딩 윈도우를 사용해야 하는 이유
        * 1. 시간복잡도 : S의 최대 길이가 10^6이기 때문에 이중 for문으로 풀 수 없다. 최소 nlogn의 방법으로 풀어야 한다.
        * 2. 구간 생성 : (시간복잡도 고려) 정수 부분 합 문제는 부분합 배열, 투 포인터를 활용할 수 있다. 문자열이므로 투 포인터 활용.
        * 3. 구간 유지 : 일정한 구간을 유지해야하므로, start 포인터와 end 포인터가 항상 일정 간격을 유지하는 슬라이딩 윈도우를 사용해야 한다.
        * */

        /*
             슬라이딩 윈도우를 유지하면서 해당 부분 문자열이 각각 A/C/G/T num의 조건을 충족하는지 여부를 체크한다.
             int start : 시작 포인터 / int end : 끝 포인터
                end - start = P

             String tmp : 부분 문자열 (개수 P)
             활용할 수 있는 String 클래스 메서드 substring. String.substring(start, end)
             단일 for문을 반복하면서 start와 end 개수가 하나씩 유지되어야 함.

             => 처음 부분 문자열의 A, C, G, T의 개수를 센다.
             => start, end 포인터를 하나씩 이동하며 빠진 문자와 더해지는 문자의 개수를 업데이트한다.
         */

        int start = 0;
        int end = P; // end-start는 P의 간격을 유지해야 한다.
        // 부분 문자열의 A, C, G, T의 개수를 세는 변수
        int Acount = 0, Ccount = 0, Gcount = 0, Tcount = 0;
        // 조건을 만족하는 개수 result
        int result = 0;

        String tmp = Dna.substring(start, end);
        for(int i=0; i<tmp.length(); i++) {
            switch (tmp.charAt(i)) {
                case 'A' :
                    Acount++;
                    break;
                case 'C' :
                    Ccount++;
                    break;
                case 'G' :
                    Gcount++;
                    break;
                case 'T' :
                    Tcount++;
                    break;
            }
        }

        if(Acount>=Anum && Ccount>=Cnum && Gcount>=Gnum && Tcount>=Tnum) result++;

                            //end는 outOfIndex 방지를 위해 S 미만이라는 조건 추가 (S-1까지 가능)
        for(int i=0; i <S && end < S; i++) {
            //제외할 문자
            char except = Dna.charAt(start);  //   3 4 5 6 7 8 9 10
            if(except == 'A') Acount--;
            else if(except == 'C') Ccount--;
            else if(except == 'G') Gcount--;
            else if(except == 'T') Tcount--;

            //포함할 문자
            char inclusion = Dna.charAt(end); // OutOfIndex 발생지점
            if(inclusion == 'A') Acount++;
            else if(inclusion == 'C') Ccount++;
            else if(inclusion == 'G') Gcount++;
            else if(inclusion == 'T') Tcount++;

            //조건 부합 여부 체크
            if(Acount>=Anum && Ccount>=Cnum && Gcount>=Gnum && Tcount>=Tnum) result++;

            //포인터 이동 (간격 P 유지)
            start++;
            end++;
        }

        System.out.println(result); // 조건 부합하는 부분문자열의 개수 출력
    }
}


// 정답 소스코드

//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.Arrays;
//        import java.util.StringTokenizer;
//
//public class P12891_DNA비밀번호 {
//    static int checkArr[];
//    static int myArr[];
//    static int checkSecret;
//
//    public static void main(String[] args) throws NumberFormatException, IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(bf.readLine());
//        int S = Integer.parseInt(st.nextToken());
//        int P = Integer.parseInt(st.nextToken());
//        int Result = 0;
//        char A[] = new char[S];
//        checkArr = new int[4];
//        myArr = new int[4];
//        checkSecret = 0;
//        A = bf.readLine().toCharArray();
//        st = new StringTokenizer(bf.readLine());
//        for (int i = 0; i < 4; i++) {
//            checkArr[i] = Integer.parseInt(st.nextToken());
//            if (checkArr[i] == 0)
//                checkSecret++;
//        }
//        for (int i = 0; i < P; i++) { //초기 P부분 문자열 처리 부분
//            Add(A[i]);
//        }
//        if (checkSecret == 4)
//            Result++;
//        // 슬라이딩 윈도우 처리 부분
//        for (int i = P; i < S; i++) {
//            int j = i - P;
//            Add(A[i]);
//            Remove(A[j]);
//            if (checkSecret == 4)  // 4자리 수에 대한 크기가 모두 충족되었을 때는 유효한 비밀번호
//                Result++;
//        }
//        System.out.println(Result);
//        bf.close();
//    }
//
//    private static void Add(char c) { //새로 들어온 문자를 처리해주는 함수
//        switch (c) {
//            case 'A':
//                myArr[0]++;
//                if (myArr[0] == checkArr[0])
//                    checkSecret++;
//                break;
//            case 'C':
//                myArr[1]++;
//                if (myArr[1] == checkArr[1])
//                    checkSecret++;
//                break;
//            case 'G':
//                myArr[2]++;
//                if (myArr[2] == checkArr[2])
//                    checkSecret++;
//                break;
//            case 'T':
//                myArr[3]++;
//                if (myArr[3] == checkArr[3])
//                    checkSecret++;
//                break;
//        }
//    }
//
//    private static void Remove(char c) { //제거되는  문자를 처리해주는 함수
//        switch (c) {
//            case 'A':
//                if (myArr[0] == checkArr[0])
//                    checkSecret--;
//                myArr[0]--;
//                break;
//            case 'C':
//                if (myArr[1] == checkArr[1])
//                    checkSecret--;
//                myArr[1]--;
//                break;
//            case 'G':
//                if (myArr[2] == checkArr[2])
//                    checkSecret--;
//                myArr[2]--;
//                break;
//            case 'T':
//                if (myArr[3] == checkArr[3])
//                    checkSecret--;
//                myArr[3]--;
//                break;
//        }
//    }