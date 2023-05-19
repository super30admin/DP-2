public class PaintHouse {

    public int minCost(int[][] costs) {

        if(costs == null) return 0;

        int n = costs.length;
        // bottom-up DP from last but row


        for(int i = n - 2; i >= 0; i--){

            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);

            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);

            costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);
        }
        // overall cost cumulates at the top row
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }

    public static void main(String[] args){

        PaintHouse object = new PaintHouse();

        int[][] cost_PaintHouse = new int[][] {{17,2,17},{16,16,5},{14,3,19}};

        int result = object.minCost(cost_PaintHouse);
        System.out.println("Minimum cost to paint all houses: " + result);
    }
}

// DP 2D ARRAY

/*
class Solution {
    public int minCost(int[][] costs) {

        if(costs == null) return 0;

        int n = costs.length;
        // bottom-up DP from last but row

        int dp[][] = new int[n][3];

        // last row of dp is same as the costs last wor
        dp[n-1][0] = costs[n-1][0];
        dp[n-1][1] = costs[n-1][1];
        dp[n-1][2] = costs[n-1][2];

        // building dp bottom-up
        for(int i = n - 2; i >= 0; i--){

            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);

            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);

            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }
        // overall cost cumulates at the top row of dp
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }


}
 */

// DP 1D ARRAY

/*
class Solution {
    public int minCost(int[][] costs) {

        if(costs == null) return 0;

        int n = costs.length;
        // bottom-up DP from last but row

        int dp[] = new int[3];

        // last row of dp is same as the costs last wor
        dp[0] = costs[n-1][0];
        dp[1] = costs[n-1][1];
        dp[2] = costs[n-1][2];

        // building dp bottom-up
        for(int i = n - 2; i >= 0; i--){

            int tempRed = dp[0];
            dp[0] = costs[i][0] + Math.min(dp[1], dp[2]);

            int tempBlue = dp[1];
            dp[1] = costs[i][1] + Math.min(tempRed, dp[2]);

            dp[2] = costs[i][2] + Math.min(tempRed, tempBlue);
        }
        // overall cost cumulates at the top row of dp
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }


}
 */
// RECURSION BASE

/*
class Solution {
    public int minCost(int[][] costs) {

        if(costs == null) return 0;

        //helper for each color
        int costRed = helper(costs, 0, 0, 0);
        int costBlue = helper(costs, 0, 1, 0);
        int costGreen = helper(costs, 0, 2, 0);

        return Math.min(costRed, Math.min(costBlue, costGreen));

    }

    private int helper(int[][] costs, int idxHoz, int color, int costIncurred){

        //base
        if(idxHoz == costs.length)  return costIncurred;
        if(color == 0){
            return Math.min(helper(costs, idxHoz + 1, 1, costIncurred + costs[idxHoz][0]), helper(costs, idxHoz + 1, 2, costIncurred + costs[idxHoz][0]));
        }

        if(color == 1){
            return Math.min(helper(costs, idxHoz + 1, 0, costIncurred + costs[idxHoz][1]), helper(costs, idxHoz + 1, 2, costIncurred + costs[idxHoz][1]));
        }

        if(color == 2){
            return Math.min(helper(costs, idxHoz + 1, 1, costIncurred + costs[idxHoz][2]), helper(costs, idxHoz + 1, 0, costIncurred + costs[idxHoz][2]));
        }

        return 9999;
    }
}
 */
