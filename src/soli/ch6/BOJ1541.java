package soli.ch6;

import _problems.ch6_greedy.P36_1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1541 implements P36_1541 {
    public static void main(String[] args) throws IOException {
        // 더하기는 그대로 더하고
        // 마이너스가 있을 때 마다 묶어주면 됨
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer minusST = new StringTokenizer(br.readLine(), "-");

        int result = 0;
        boolean isFirstGroup = true;

        // 마이너스는 마이너스대로 묶어줘야 하니까
        while(minusST.hasMoreTokens()) {
            int sum = 0;
            StringTokenizer plusST = new StringTokenizer(minusST.nextToken(), "+");
            // 각 그룹 별로 더해주기
            while(plusST.hasMoreTokens()) {
                sum += Integer.parseInt(plusST.nextToken());
            }
            // 만약에 첫번째 그룹?
            if(isFirstGroup) {
                // 결과값 그대로 두고
                result = sum;
                // 아니면(마이너스 붙은 그룹)
                isFirstGroup = false;
            } else {
                result -= sum;
            }
        }
        System.out.println(result);
    }
}
