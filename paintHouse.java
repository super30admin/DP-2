//Amazon interview quesiton 256 prime leetcode
//Time Complexity = O(n)
//Space complexity = O(n)
//The houses should be adjacent wit different colors it should not be same
//paintHouse based on 3 colors and storing in 2d array based on last row considering with minimum cost,
// rows = number of houses and coulmns = color
class Solution{
    public int minCost(int[][] costs){
        int n = costs.length;
        int [][] dp = new int [n][3];
        for(int j=0;j<3;j++){
            dp[n-1][j] = costs[n-1][j];
        }
        for(int i=n-2;i>=0;i--){
            //0->Red ;1->Green;2->Blue
            dp[i][0] = costs[i][0]+Math.min(dp[i+1][1],dp[i+2][2]);
            dp[i][1] = costs[i][1]+Math.min(dp[i+1][0],dp[i+2][2]);
            dp[i][2] = costs[i][2]+Math.min(dp[i+1][0],dp[i+2][1]);
        }
        return Math.min(dp[0][0],Math.min(dp[0][1],dp[0][2]));
    }
}