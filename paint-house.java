public class PaintHouse {

    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        // Iterate bottom up from the second-to-last house to the first.
        for (int i = costs.length - 2; i >= 0; i--) { 
            // Min cost to paint house 'i' red is its original cost plus the
            // min cost of painting house 'i+1' blue or green.
            costs[i][0] += Math.min(costs[i + 1][1], costs[i + 1][2]);

            // Min cost to paint house 'i' blue
            costs[i][1] += Math.min(costs[i + 1][0], costs[i + 1][2]);

            // Min cost to paint house 'i' green
            costs[i][2] += Math.min(costs[i + 1][0], costs[i + 1][1]);
        }
        return Math.min(Math.min(costs[0][0], costs[0][1]), costs[0][2]);
    }

    public static void main(String[] args) {
        PaintHouse solver = new PaintHouse();
        int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        
        System.out.println("The minimum cost is: " + solver.minCost(costs)); // Expected output: 10
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english 
// used the bottom up approach to calculate the minimum costs
//stored the total cost in the row above
//Chose the minimum from the first row

// Your code here along with comments explaining your approach