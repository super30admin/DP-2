// ## Problem1(https://leetcode.com/problems/paint-house/)
// Time Complexity : O(3*2^(m))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.
// Brute force approach

class Solution {
    public int minCost(int[][] costs) {
        // house 0 color red
        int costR = helper(costs, 0, 0);
        // house 1 color blue
        int costB = helper(costs, 0, 1);
        // house 2 color green
        int costG = helper(costs, 0, 2);
        return Math.min(costR,Math.min(costB,costG));
    }
    //houses - houseIndex
    //colorIndex what i used will dictate what should i use in next row
    private int helper(int[][]costs,int houseIndex, int colorIndex){
        //if my index go out of bound
        if(houseIndex == costs.length) return 0;
        //if i chose color red - 0th index then i have two options green or yblue
        if(colorIndex == 0){
             return costs[houseIndex][0] + Math.min(helper(costs, houseIndex+1, 2), helper(costs, houseIndex+1, 1));
        }
        //if my current color is 1 - blue
        if(colorIndex == 1){
             return costs[houseIndex][1] + Math.min(helper(costs, houseIndex+1, 0), helper(costs, houseIndex+1, 2));}
        //if my current color is 2 - green
        if(colorIndex == 2){
             return costs[houseIndex][2] + Math.min(helper(costs, houseIndex+1, 0), helper(costs, houseIndex+1, 1));
        }
        return 1;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.


class Solution {
    public int minCost(int[][] costs) {
        //no. of houses
        int n = costs.length;
        int[][] dp = new int[n][3];
        //filling last row with the same values in costs
        dp[n-1][0] = costs[n-1][0];
        dp[n-1][1] = costs[n-1][1];
        dp[n-1][2] = costs[n-1][2];
        for(int i=n-2; i>=0; i--){
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1],dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0],dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][1],dp[i+1][0]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.

class Solution {
    public int minCost(int[][] costs) {
        //no. of houses
        int n = costs.length;
        int[] dp = new int[3];
        //filling last row with the same values in costs
        dp[0] = costs[n-1][0];
        dp[1] = costs[n-1][1];
        dp[2] = costs[n-1][2];
        for(int i=n-2; i>=0; i--){
            int tempR = dp[0];
            dp[0] = costs[i][0] + Math.min(dp[1],dp[2]);
            int tempB = dp[1];
            dp[1] = costs[i][1] + Math.min(tempR,dp[2]);
            dp[2] = costs[i][2] + Math.min(tempB,tempR);
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.
class Solution {
    public int minCost(int[][] costs) {
        //no. of houses
        int n = costs.length;
        //filling last row with the same values in costs
        int costRed = costs[n-1][0];
        int costBlue = costs[n-1][1];
        int costGreen = costs[n-1][2];
        for(int i=n-2; i>=0; i--){
            int tempR = costRed;
            costRed = costs[i][0] + Math.min(costBlue,costGreen);
            int tempB = costBlue;
            costBlue = costs[i][1] + Math.min(tempR,costGreen);
            costGreen = costs[i][2] + Math.min(tempB,tempR);
        }
        return Math.min(costRed, Math.min(costBlue, costGreen));
    }
}

// Time Complexity : O(2 ^(m+n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.


// Your code here along with comments explaining your approach

// # DP-2
// ## Problem2 (https://leetcode.com/problems/coin-change-2/)
// Brute force approach
class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null) return 0;
        return helper(amount, coins, 0);
    }
    private int helper(int amount, int[] coins, int index){
        //one way - valid path
        if(amount == 0) return 1;
        if(amount < 0 || index == coins.length) return 0;
        //choose
        int case1 = helper(amount - coins[index], coins, index); 
        //not choose
        int case2 = helper(amount, coins, index + 1);
        return case1 + case2;
        
    }
}
// Time Complexity : O(mn)
// Space Complexity : 0(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.

class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null) return 0;
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        //By default initiated with 0
        for(int i=1; i<=m; i++){
            for(int j=0; j<=n; j++){
                //till current amount < denominations
                if(j < coins[i - 1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[m][n];
    }
}
// Time Complexity : O(mn)
// Space Complexity : 0(n) - Optimized space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.
class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null) return 0;
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n+1];
        dp[0] = 1;
        //By default initiated with 0
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                //till current amount < denominations
                if(j < coins[i - 1]){
                    dp[j] = dp[j];
                }else{
                    dp[j] = dp[j] + dp[j - coins[i-1]];
                }
            }
        }
        return dp[n];
    }
}

