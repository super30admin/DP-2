// Time Complexity : O(n)
// Space Complexity : O(n)
// Any problem you faced while coding this : no
// Approach: Tabulation: 2d matrix. Start with painting one house. fill eht rest of the table by 
// choosing color a by adding cost of painting house with color a and cost of painting already painted 
// houses so far

public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public static int minCost(int[][] costs) {
        // write your code here
        int dp[][] = new int[costs.length][costs[0].length];
        for(int i=0;i<costs[0].length;i++){
            dp[costs.length-1][i] = costs[costs.length-1][i];
        }
        for(int i=costs.length-2;i>=0;i--){
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][1], dp[i+1][0]);
            //System.out.println(dp[i][0]+"-"+dp[i][1]+"-"+dp[i][2]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
    public static void main(String args[]){
        int costs[][] = {{1,2,3},{1,4,6}};
        System.out.println(minCost(costs));
    }
}