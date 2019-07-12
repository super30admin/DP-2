import java.util.*;
//Time complexity -> o(m*n)
//Space complexity -> o(m*n)

class Change {
      public static int change(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i ++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= amount; j ++) {
                if (coins[i - 1] > j) { 
                    dp[i][j] = dp[i - 1][j];
                } else { 
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }
  
	public static void main (String[] args) {
	  int arr[] = {1,2,5};
		System.out.println(change(arr,5));
		
	}
}