package day_0822.Recursive;

public class Recursive01 {
    static int answer = 0;
    public static void main(String[] args) {
        int n = 1;

//        while(n <= 5) {
//            answer += n;
//            n++;
//        }
//        System.out.println(answer);
        recursive(n);
        System.out.println(answer);
    }
    public static void recursive(int n) {
        // basis part
        if(n > 5) {
            return;
        }
        System.out.println(n + " ");
        answer += n;
        recursive(n + 1);
        // inductive part(파생 파트) (while, for기능)

    }
}
