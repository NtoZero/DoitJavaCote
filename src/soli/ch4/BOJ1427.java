package soli.ch4;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 4213 이런 식으로 들어옴
        // 문자 하나 씩 받아야 함
        String str = br.readLine();

        // 배열에 넣기
        List<Integer> integers = new ArrayList<>();

        for(char c : str.toCharArray()) {
            // character -> Numeric으로 바꿔주기
            integers.add(Character.getNumericValue(c));
        }

        Collections.sort(integers, Collections.reverseOrder());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i<integers.size() ; i++) {
            bw.write(Integer.toString(integers.get(i)));
        }
        bw.write("\n");
        bw.flush();
    }
}
