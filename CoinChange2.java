
// Exhaustive approach - Fails at runtime because its exponential
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        // null check
        if(coins==null || coins.length==0) return 0;
        return helper(coins,amount,0);
    }
    private int helper(int[] coins,int amount,int idx){
        // base
        if(amount<0 || idx==coins.length) return 0;
        if(amount == 0) return 1;
        
        //logic
        int case1 = helper(coins,amount-coins[idx],idx);
        
        int case0 = helper(coins,amount, idx+1);
        
        return case1+case0;
    }
}

// Time Complexity - O(2 power n)
// Space Complexity - O(2 power n)

// DP Solution - 2D Array
public class CoinChange2DP_2 {
    public int change(int amount, int[] coins) {
        if(coins==null || coins.length==0) return 0;
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(j<coins[i-1]){ // Copy values from above row till amount is less than the denomination
                    dp[i][j] = dp[i-1][j]; // NOT CHOOSE case
                }else{ // CHOOSE case
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m][n];
    }
}

// Time Complexity - O(m*n)
// Space Complexity - O(n)

// DP Solution - 1D Array
public class CoinChange2DP_3 {
    public int change(int amount, int[] coins) {
        if(coins==null || coins.length==0) return 0;
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(j>=coins[i-1]){
                    dp[j] = dp[j] + dp[j-coins[i-1]];
                }
            }
        }
        return dp[n];
    }
}

// Time Complexity - O(m*n)
// Space Complexity - O(n)