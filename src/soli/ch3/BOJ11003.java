package soli.ch3;

import problems.ch3_data_structure.ch3_3_two_pointer.P10_11003;

public class BOJ11003 implements P10_11003 {

    public static void main(String[] args) {

        // 12 , 3
        // 1 5 2 3 6 2 3 7 3 5 2 6 -> A1, A2, A3 ...AN
        // 옮겨가면서 작은 수 뽑기
        // i = 0 ; i < N ; i ++
        // deque 넣고, 빼고,
        // 어떤 거 넣을건지?
        // 출력하는 deque : i - L + 1 부터 i 까지 중에 제일 작은 거 넣어야 함 (i=0 deque에 A[i] 넣기)
        //
        // if (A[i-1] < A[i])
        // deque.add(A[i])
        // else if (A[i-1] > A[i])
        // deque.add(A[i-1])



    }
}
