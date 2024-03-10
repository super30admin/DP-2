
//Time Complexity is O(n*amount) where n=size of the coins array and Space Complexity is O(n*amount) dp array
class Solution {
    public int change(int amount, int[] coins) {
        

        int n = coins.length;
        int m = amount;

        int[][] dp = new int[n+1][m+1];

        dp[0][0] =1;

        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }

        
        return dp[n][m];
    }

    
}
