package sortingAndSearching;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KNearestPointsToOrigin {

    public static void main(String[] args) {

        int[][] points = {{1,3},{-2,2}};
        int K = 1;

        int[][] ans1 = kClosest(points, K);
        System.out.print(ans1[0][0] + " ");
        System.out.println(ans1[0][1]);

        int[][] ans2 = kClosestWithMaxHeap(points, K);
        System.out.print(ans2[0][0] + " ");
        System.out.println(ans2[0][1]);

    }

    public static int[][] kClosest(int[][] points, int K) {
        int N = points.length;
        int[] dists = new int[N];
        for (int i = 0; i < N; ++i)
            dists[i] = dist(points[i]);

        Arrays.sort(dists);
        int distK = dists[K-1];

        int[][] ans = new int[K][2];
        int t = 0;
        for (int i = 0; i < N; ++i)
            if (dist(points[i]) <= distK)
                ans[t++] = points[i];
        return ans;
    }

    public static int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public static int[][] kClosestWithMaxHeap(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(K, (a, b) -> (b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));
        int[][] res=new int[K][2];
        for(int[] point : points){
            maxHeap.offer(point);
            if(maxHeap.size() > K)
                maxHeap.poll();
        }

        int index = 0;
        while(!maxHeap.isEmpty()) {
            res[index]=maxHeap.poll();
            index++;
        }
        return res;
    }
}
