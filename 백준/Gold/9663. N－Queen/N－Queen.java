import java.util.Scanner;

public class Main {

    static int N, cols[], ans;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        cols = new int[N+1];
        ans = 0;

        setQueen(1);
        System.out.println(ans);
    }

    public static void setQueen(int rowNo) {

        if(!isAvailable(rowNo-1)) return;

        if(rowNo>N) {
            ans++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            cols[rowNo] = i;
            setQueen(rowNo+1);
        }
    }

    private static boolean isAvailable(int rowNo) {

        for (int j =1; j < rowNo; j++) {
            if(cols[j] == cols[rowNo] ||
                    rowNo - j == Math.abs(cols[rowNo]-cols[j]) ) return false;
        }
        return true;
    }
}