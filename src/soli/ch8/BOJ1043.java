package soli.ch8;

import _problems.ch8_graph.P52_1043;

import java.io.*;
import java.util.*;

public class BOJ1043 implements P52_1043 {
    static int N, M;

    static int truth;
    static int[] T;
    static int count;
    static ArrayList<Integer>[] A;
    static boolean[] knowTruth;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 사람의 수 N
        N = Integer.parseInt(st.nextToken());
        // 파티의 수 M
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        T = new int[N+1];

        // 진실을 아는 사람의 수, 번호
        truth = Integer.parseInt(st.nextToken());
        if(truth != 0) {
            for(int i = 0 ; i < truth ; i++) {
                T[i] = Integer.parseInt(st.nextToken());
            }
        } else {
            count = M;
            System.out.println(count);
            return;
        }

        A = new ArrayList[M];
        for(int i = 0 ; i < M ; i++) {
            A[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            // 파티장 참석 사람 수
            int num = Integer.parseInt(st.nextToken());

            for(int j = 0 ; j < num ; j++) {
                int partyPeople = Integer.parseInt(st.nextToken());
                A[i].add(partyPeople);
            }
        }
        // 진실을 아는 사람
        knowTruth = new boolean[N+1];
        for(int i = 0; i < truth; i++) {
            knowTruth[T[i]] = true;
        }

        for (int i = 0 ; i < M ; i++) {
            // 파티에 있던 사람 다 돌면서 검색
            for(int person : A[i]) {
                // 파티에 있던 사람 중에 진실 아는 사람 있으면 그 파티에는 진실만 말해야 함
                // 그 파티원들도 진실만 알게 됨
                if(knowTruth[person]) {
                    for(int attend : A[i]) {
                        knowTruth[attend] = true;
                    }
                    break;
                }
            }
        }

        int count = 0;
        for(ArrayList<Integer> party : A) {
            boolean canLie = true;
            for(Integer person : party) {
                // 만약에 진실을 아는 사람 있으면
                if(knowTruth[person]) {
                    canLie = false;
                    break;
                }
            }
            if(canLie) {
                count++;
            }

        }
        System.out.println(count);
    }
}
