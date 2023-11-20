import java.util.Arrays;

public class Main_runner {
    public static void main(String[] args) {
        QuickFindUF qfuf = new QuickFindUF(10);
        qfuf.union(0, 1);
        qfuf.union(2, 3);
        qfuf.union(0, 3);
        qfuf.union(6, 7);
        qfuf.union(8, 9);
        qfuf.union(3, 7);
        System.out.println(qfuf.connected(3, 8));
        System.out.println(Arrays.toString(qfuf.connections));

        QuickUnionUF quuf = new QuickUnionUF(10);
        quuf.union(0, 1);
        quuf.union(2, 3);
        quuf.union(0, 3);
        quuf.union(6, 7);
        quuf.union(8, 9);
        quuf.union(3, 7);
        System.out.println(quuf.connected(3, 7));
        System.out.println(Arrays.toString(quuf.connections));
    }
}