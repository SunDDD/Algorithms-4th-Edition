package algorithms.week1.union;

/**
 * @author Carlos
 * @description 加权快速合并算法
 * @Date 2019/9/5
 */

public class WeightedQuickUnionUF {

    private int[] id;
    private int[] sz;

    public WeightedQuickUnionUF(int N) {
        id = new int[N];
        sz = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }

    }

    private int root(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]]; //路径上的每个节点都指向它在路径上的祖父节点
            p = id[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);

        if (pRoot == qRoot) {
            return;
        }

        if (sz[pRoot] > sz[qRoot]) {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        } else {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }

    }

    public static void main(String[] args) {
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(8);
        System.out.println("1和2是否connected? : " + uf.connected(1, 2));
        System.out.println("uf.union(1, 2)");
        uf.union(1, 2);
        System.out.println("1和2是否connected? : " + uf.connected(1, 2));
    }

}
