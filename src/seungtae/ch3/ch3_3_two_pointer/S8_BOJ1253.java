package seungtae.ch3.ch3_3_two_pointer;

import _problems.ch3_data_structure.ch3_3_two_pointer.P8_1253;

import java.util.Arrays;
import java.util.Scanner;

public class S8_BOJ1253 implements P8_1253 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] arr = new long[N];
        for(int i=0; i<N; i++) {
            arr[i] = Long.valueOf(sc.nextInt());
        }

        int count = 0, start = 0, end = N-1;
        long num = 0, sum = 0;

        // 정렬한다.
        Arrays.sort(arr);

        // 다른 두 수의 합이 배열의 특정 수 num와 같다면 그 수는 좋은 수이다.
        // N의 최대값은 2000이므로 2*10^3으로 볼 수 있다. => 이중for문의 사용이 가능하다.
            // 다만, 투 포인터를 사용하지 않으면 삼중for문을 사용해야하기 때문에 시간이 초과된다.

        // 배열의 모든 요소를 순회하며 해당 값 num이 '좋은 수'인지 판별해야한다.
        for(int i=0; i<arr.length; i++) {
            start = 0;
            end = N-1;
            num = arr[i];

            while(start<end) {
                //합 sum 값은 start, end가 변할 때마다 재할당.
                sum = arr[start]+arr[end];
                // 현재 배열은 정렬된 상태이므로,
                if(sum > num) { // sum이 num보다 크면 end를 줄인다.
                    end--;
                } else if(sum < num) { //num이 sum보다 크면 start를 줄인다.
                    start++;
                } else { // sum = num
                    System.out.println("num :" + num);
                    System.out.println("start :" +start + ", end :" +end );

                    //🔥단, start와 end는 num의 인덱스 i와 다른 위치에 있어야 한다.
                        //num은 서로 다른 수의 합이어야 하므로.
                    if(start!=i && end!=i) {
                        count++;
                        break;
                    } else if(start==i) {
                        start++;
                    } else if(end==i) {
                        end--;
                    }

                }
            }
        }
            System.out.println(count);
    }
}
        /*
            숫자 0에 대한 생각을 해야한다.
            또한 여러 숫자가 같은 경우도 생각해야 한다.

            예를들어 지금 코드로는 숫자 배열이
            0 / 0  / 1 이면

            start가 0이고 find의 인덱스가 1, end의 인덱스가 1일 때
            서로 겹치지는 않지만
            arr[start] + arr[end] =
            arr[0] + arr[1] =
            0+0 = 0이니까 count++이 성립되는데
            조건이 '서로 다른 수'이니까 자기 자신을 활용한 이 경우의 수는 제외해야 하는 것 같다.
         */
