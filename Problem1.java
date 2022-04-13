//Time Complexity O(M)
//Space Complexity O(1)
// where m = size of costs

public class Problem1 {
    public static int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;

        for (int i = costs.length - 2; i >= 0; i--) {
            costs[i][0] = costs[i][0] + (Math.min(costs[i + 1][1], costs[i + 1][2]));
            costs[i][1] = costs[i][1] + (Math.min(costs[i + 1][0], costs[i + 1][2]));
            costs[i][2] = costs[i][2] + (Math.min(costs[i + 1][1], costs[i + 1][0]));
        }
        return Math.min(costs[0][0], (Math.min(costs[0][1], costs[0][2])));
    }

    public static void main(String[] args) {
        int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        int result = Problem1.minCost(costs);
        System.out.println("Final result " + result);
    }

}
