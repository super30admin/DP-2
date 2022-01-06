// Time Complexity : O(n*m), where n is no. of coins and m is the amount(checking each possible amount value upto target amount with each denomination)
// Space Complexity : O(n*m) where n is no. of coins and m is the amount(creating a matrix)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No Problems faced


// Your code here along with comments explaining your approach
public class Problem2 {
	public int change(int amount, int[] coins) {
		
        if(coins==null || coins.length==0) return 0;
        if(amount==0) return 1;
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                if(coins[i-1]>j) {
                    dp[i][j] = dp[i-1][j];
                } if(coins[i-1]<j) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                } 
                if(coins[i-1]==j) {
                    dp[i][j] = 1+dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
