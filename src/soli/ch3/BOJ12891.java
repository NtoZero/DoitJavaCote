package soli.ch3;

import _problems.ch3_data_structure.ch3_3_two_pointer.P9_12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ12891 implements P9_12891 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());   // 민호쓰 임의 문자열 길이 S
        int P = Integer.parseInt(st.nextToken());   // 비밀번호 부분문자열 길이 P

        String dna = br.readLine(); //  DNA 문자열

        int[] arr = new int[4];  // 부분 문자열에 포함되어야 할 A, C, G, T  최소 개수
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 4 ; i ++ ) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 최소 개수 각 문자열이랑 map 형태로 저장
        Map<Character, Integer> minChar = new HashMap<>();
        minChar.put('A', arr[0]);
        minChar.put('C', arr[1]);
        minChar.put('G', arr[2]);
        minChar.put('T', arr[3]);

        // 부분 문자열에서 각 개수 저장
        Map<Character, Integer> partChar = new HashMap<>();

        // dna 에서 P 개 문자 검사
        for(int i = 0 ; i < P ; i ++) {
            char c = dna.charAt(i);
            // 문자 없으면 1개 추가, 있으면 ++
            partChar.put(c, partChar.get(c) == null ? 1 : partChar.get(c) + 1);
        }

        int count = 0;
        boolean isValid = true;
        // minChar 이랑 partChar 비교
        for(char c : minChar.keySet()) {    // Map에 값을 전체 출력하기 위해서 keySet() 메소드
            // 최소로 만족 해야 하는 값 > 부분문자 (없으면 0 됨) -> if 문 내부 true
            // 실패 해야함
            if(minChar.get(c) > (partChar.get(c) == null ? 0 : partChar.get(c))) {
                isValid = false;
                break;
            }
        }
        if(isValid) {
            count++;
        }

        // P부터 S까지 검사
        for(int i = P; i < S ; i ++) {
            char start = dna.charAt(i - P);
            char end = dna.charAt(i);

            // 부분 문자열에서 문자 추가
            partChar.put(end, partChar.get(end) == null ? 1 : partChar.get(end) + 1);

            // 부분 문자열에서 문자 제거
            partChar.put(start, partChar.get(start) -1 );

            // 비밀번호가 가능한 경우인지 검사
            isValid = true;
            for(char c : minChar.keySet()) {
                if(minChar.get(c) > (partChar.get(c) == null ? 0 : partChar.get(c))){
                    isValid = false;
                    break;
                }
            }

            if(isValid) {
                count++;
            }
        }

        System.out.println(count);
    }
}
