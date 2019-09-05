package algorithms.week1.union;

/**
 * @author Carlos
 * @description 快速合并
 * @Date 2019/9/5
 */

public class QuickUnionUF {

    private int[] id;

    public QuickUnionUF(int N) {

        id = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {

        while (i != id[i]) {
            i = id[i];
        }

        return i;
    }

    public boolean connected(int p, int q) {

        return root(p) == root(q);

    }

    public void union(int i, int j) {
        int pRoot = root(i);
        int qRoot = root(j);

        id[pRoot] = qRoot;
    }

    public static void main(String[] args) {
        QuickUnionUF uf = new QuickUnionUF(8);
        System.out.println("1和2是否connected? : " + uf.connected(1, 2));
        System.out.println("uf.union(1, 2)");
        uf.union(1, 2);
        System.out.println("1和2是否connected? : " + uf.connected(1, 2));
    }

}
