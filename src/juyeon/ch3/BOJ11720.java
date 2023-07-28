package juyeon.ch3;

public class BOJ11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
//        String str = sc.next();
//
//        int sum = 0;
//        for( int i = 0; i < N; i++ ){
//            sum += str.charAt(i) - '0';
//        }

        String[] str = sc.next().split("");
        int sum = 0;
        for( int i = 0; i < N; i++ ){
            sum += parseInt(str[i]);
        }

        System.out.println(sum);
    }
}
