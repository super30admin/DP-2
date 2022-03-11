// Time Complexity : O(n*m)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class coin_chng_2 {
    public int change(int amount, int[] coins) {
        if(coins == null) return 0;
        int[] dp = new int[amount+1];
        
        dp[0] = 1;
        
        for(int i=1; i < coins.length+1 ; i++) {
            for(int j=1; j < dp.length; j++) {
                if(coins[i-1] <= j)
                    dp[j] += dp[j - coins[i-1]];
            }
        }
        return dp[amount];
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Don't have LC PRemium
// Any problem you faced while coding this :No

class Solution {
    public static int minCost(int[][] costs) {
        int n = costs.length - 1;
        int costR = costs[n][0];
        int costG = costs[n][1];
        int costB = costs[n][2];
        for(int i = costs.length-2; i>=0; i--) {
            int tempR = costR;
            int tempG = costG;
            costR = costs[i][0] + Math.min(costG, costB);
            costG = costs[i][1] + Math.min(tempR, costB);
            costB = costs[i][2] + Math.min(tempR, tempG);
        }
        return Math.min(costR, Math.min(costG, costB));
    }
    
    public static void main(String[] args) {
        int[][] arr1 = {{17, 2, 17}, {16, 3, 5}, {14, 3, 19}};
        int a = minCost(arr1);
        System.out.println(a);
    }
}