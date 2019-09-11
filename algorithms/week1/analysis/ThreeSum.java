package algorithms.week1.analysis;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * @author Carlos
 * @description 三数之和(暴力算法)
 * @Date 2019/9/11
 *
 * 测试数据
 *
 * * D:\Java\Video_Git\out\production\Video_Git>java algorithms.week1.analysis.ThreeSum 8ints.txt
 *  * 4
 *  * elapsed time = 0.001
 *  *
 *  * D:\Java\Video_Git\out\production\Video_Git>java algorithms.week1.analysis.ThreeSum 1Kints.txt
 *  * 70
 *  * elapsed time = 0.224
 *  *
 *  * D:\Java\Video_Git\out\production\Video_Git>java algorithms.week1.analysis.ThreeSum 2Kints.txt
 *  * 528
 *  * elapsed time = 1.742
 *  *
 *  * D:\Java\Video_Git\out\production\Video_Git>java algorithms.week1.analysis.ThreeSum 4Kints.txt
 *  * 4039
 *  * elapsed time = 13.983
 *  *
 *  *
 */

public class ThreeSum {

    public static int count(int[] a) {
        int N = a.length;
        int count = 0;

        for(int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        Stopwatch stopwatch = new Stopwatch();
        StdOut.println(count(a));
        double time = stopwatch.elapsedTime();
        StdOut.println("elapsed time = " + time);
    }

}
