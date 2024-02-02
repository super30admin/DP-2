//time complexity = O(m*n), space compelxity - O(m*n)
//function uses bottom-up approach 
//It iterates through coins and amounts calculating number of ways 
// result is found in  dp[m][n] , m - number of coins
class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int [][] dp = new int[m+1][n+1];
        dp[0][0] =1;
       
        for(int i =1;i<=m;i++){
            for(int j = 0;j <= n;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j]; // no choose case;
                }
                else dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];
            }
        }
        return dp[m][n];
        
    }
}