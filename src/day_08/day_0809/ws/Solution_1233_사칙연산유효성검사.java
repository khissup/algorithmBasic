package day_08.day_0809.ws;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;


//수식표현을 이진트리 사용하여 표현
public class Solution_1233_사칙연산유효성검사 {

    static int N;
    static Node[] tree;
    static StringBuilder sb = null;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("res/input1233.txt"));
        Scanner sc = new Scanner(System.in);

        for(int t=1;t<=10;t++) {
            N = Integer.parseInt(sc.nextLine());
            tree = new Node[N+1];
            sb = new StringBuilder();
            for(int i=1;i<=N;i++) {
                StringTokenizer st = new StringTokenizer(sc.nextLine());
                int idx = Integer.parseInt(st.nextToken());
                Node node = new Node();
                if(i == idx) {
                    tree[idx] = node;
                }
                node.data = st.nextToken().trim().charAt(0);
                if(st.hasMoreElements()) {
                    node.L = Integer.parseInt(st.nextToken());
                }
                if(st.hasMoreElements()) {
                    node.R = Integer.parseInt(st.nextToken());
                }
            }

            String msg = inorder(tree[1]);
//        	String msg = postorder(tree[1]);
//        	System.out.println(msg);
            System.out.printf("#%d %d%n",t,check(msg));
        }
    }

    static int check(String r) {
        for (int i = 0; i < r.length() - 1; i++) {
            if (r.charAt(i) == '+' || r.charAt(i) == '-' || r.charAt(i) == '*' || r.charAt(i) == '/') {
                if (r.charAt(i + 1) == '+' || r.charAt(i + 1) == '-' || r.charAt(i + 1) == '*'
                        || r.charAt(i + 1) == '/') {
                    return 0;
                }
            }

        }
        return 1;
    }
    // preorder // 전위순회
    static String inorder(Node n) { // 중위순회
        if(n != null) {
            inorder(tree[n.L]);
            sb.append(n.data);
            inorder(tree[n.R]);
        }
        return sb.toString();
    }
    static String postorder(Node n) { // 후위순회
        if(n != null) {
            inorder(tree[n.L]);
            inorder(tree[n.R]);
            sb.append(n.data);
        }
        return sb.toString();
    }
    static class Node{
        char data;
        int L;
        int R;

        public String toString() {
            return "Node [data=" + data + ", L=" + L + ", R=" + R + "]";
        }
    }
}

