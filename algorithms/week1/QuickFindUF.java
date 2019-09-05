package algorithms.week1;

/**
 * @author Carlos
 * @description 快速查找
 * @Date 2019/9/5
 */

public class QuickFindUF {

    private int[] id;

    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    public static void main(String[] args) {
        QuickFindUF uf = new QuickFindUF(8);
        System.out.println("1和2是否connected? : " + uf.connected(1, 2));
        System.out.println("uf.union(1, 2)");
        uf.union(1, 2);
        System.out.println("1和2是否connected? : " + uf.connected(1, 2));
    }

}
