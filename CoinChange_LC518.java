//Time: O(m*n)
// where m = no of rows in coins, n = amount

//Space = O(m*n)

public int change(int amount, int[] coins) {
        int m = coins.length + 1;
        int n = amount + 1;
        
        int[][] dp = new int[m][n];
        
        //fill 1st row, as there is 1 way 
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        
        for(int i = 1; i < n; i++){
            dp[0][i] = 0;
        }
        
        //fill dp array
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(j< coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i -1]];
                }
            }
        }
        return dp[m-1][n-1];
    }