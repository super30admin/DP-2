/*this implementation uses dynamic programming approach to determine the minimum cost to paint houses
 * the time complexity of this approach is O(n)*/
class MinCost {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        int[] prevRow = new int[3];
        prevRow[0] = costs[0][0];
        prevRow[1] = costs[0][1];
        prevRow[2] = costs[0][2];
        int prevMin = Math.min(Math.min(prevRow[0], prevRow[1]), prevRow[2]);
        for (int i = 1; i < n; i++) {
            int[] curRow = new int[3];
            curRow[0] = costs[i][0] + Math.min(prevRow[1], prevRow[2]);
            curRow[1] = costs[i][1] + Math.min(prevRow[0], prevRow[2]);
            curRow[2] = costs[i][2] + Math.min(prevRow[0], prevRow[1]);
            int curMin = Math.min(Math.min(curRow[0], curRow[1]), curRow[2]);
            prevRow = curRow;
            prevMin = curMin;
        }
        return prevMin;
    }
    public static void main(String[] args) {
        int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        MinCost solution = new MinCost();
        int minCost = solution.minCost(costs);
        System.out.println("Minimum cost to paint all houses: " + minCost);
    }
}

