package algorithms.week1.analysis;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;


/**
 * @author Carlos
 * @description 三数求和（使用二分查找）
 * @Date 2019/9/11
 * 测试数据（相较暴力求解在大数据量有明显提升）：
 *
 * D:\Java\Video_Git\out\production\Video_Git>java algorithms.week1.analysis.BinarySearchThreeSum 8ints.txt
 * 4
 * elapsed time = 0.002
 *
 * D:\Java\Video_Git\out\production\Video_Git>java algorithms.week1.analysis.BinarySearchThreeSum 1Kints.txt
 * 70
 * elapsed time = 0.035
 *
 * D:\Java\Video_Git\out\production\Video_Git>java algorithms.week1.analysis.BinarySearchThreeSum 2Kints.txt
 * 528
 * elapsed time = 0.175
 *
 * D:\Java\Video_Git\out\production\Video_Git>java algorithms.week1.analysis.BinarySearchThreeSum 4Kints.txt
 * 4039
 * elapsed time = 0.625
 *
 * D:\Java\Video_Git\out\production\Video_Git>java algorithms.week1.analysis.BinarySearchThreeSum 8Kints.txt
 * 32074
 * elapsed time = 2.382
 *
 * D:\Java\Video_Git\out\production\Video_Git>java algorithms.week1.analysis.BinarySearchThreeSum 16Kints.txt
 * 255181
 * elapsed time = 10.874
 *
 */

public class BinarySearchThreeSum {

    public static int binarySearch(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (key > a[mid]) {
                lo = mid + 1;
            } else if (key < a[mid]) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static int count(int[] a) {
        int N = a.length;
        int count = 0;

        Arrays.sort(a);

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int result = binarySearch(a, -(a[i] + a[j]));
                if (result != -1 && result != i && result != j) {
                    count++;
                }
            }
        }
        return count / 3; //同一组数据重复计算三次，除3为正确数量。
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        Stopwatch stopwatch = new Stopwatch();
        StdOut.println(count(a));
        double time = stopwatch.elapsedTime();
        StdOut.println("elapsed time = " + time);
    }

}
