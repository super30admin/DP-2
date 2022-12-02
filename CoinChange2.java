
// Time Complexity :O(MN) Where M is the no of coins and N is the amount
// Space Complexity :O(MN) because we use 2d matrix
// Did this code successfully run on Leetcode :Yes
public class CoinChange2 {

	public int change(int amount, int[] coins) {
        
        int row = coins.length;
        int col = amount;
        int[][] dp = new int[row+1][col+1];
        for(int i=0;i<=row;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                if(j<coins[i-1])
                    dp[i][j]= dp[i-1][j];
                 else
                   dp[i][j]= dp[i-1][j]+dp[i][j-coins[i-1]]; 
            }
        }

        return dp[row][col];
    }
}
