// Time Complexity : O(m * n), m is the number of houses (rows) and n is the number of colors
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// code iterates through each house starting from the second house (i = 1). For each house, it considers each color option (j = 0 to n-1) and calculates
// the minimum cost of painting the current house with a color that doesn't match the color of the previous house.
class problem1 {
    public int minCost(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length;
        int i;
        int j;
        for (i = 1; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (j == 0)
                    costs[i][j] += Math.min(costs[i-1][j+1], costs[i-1][j+2]);
                else if (j == n-1)
                    costs[i][j] += Math.min(costs[i-1][j-1], costs[i-1][j-2]);
                else
                    costs[i][j] += Math.min(costs[i-1][j-1], costs[i-1][j+1]);
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int x: costs[m-1]) {
            if (x < answer)
                answer = x;
        }
        return answer;
    }
}