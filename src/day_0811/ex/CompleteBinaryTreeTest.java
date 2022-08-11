package day_0811.ex;

public class CompleteBinaryTreeTest {
    public static void main(String[] args) {
        CompleteBinaryTree tree = new CompleteBinaryTree(9);
        for (int i = 0; i < 9; i++) {
            tree.add((char) ('A' + i));
        }
        tree.bfs();
        tree.dfs();
        tree.bfs2();

        tree.dfsByPreOrder(1); // 본인을 가장 먼저 탐색
        System.out.println();
        tree.dfsByInOrder(1); // 본인을 중간에 탐색
        System.out.println();
        tree.dfsByPostOrder(1); // 본인을 제일 마지막에 탐색
        System.out.println();
    }
}

/*
                                A

                    B                         C

             D              E           F           G

      H             I
 */