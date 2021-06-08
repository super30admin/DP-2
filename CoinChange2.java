//Time Compolexity: O(n x amount)
//Space Complexity:O(amount)

class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        // using 1D array instead of 2D.
        int[] dp=new int[amount+1];
        // if amount=0 and coins={}
       dp[0]=1;      
    
        for(int i=1;i<n+1;i++)
        {
            for(int j=0;j<amount+1;j++)
            {
              // if current amount j< coins[i-1]
                  
                  // then dp[j] remains same
                
                if (j>= coins[i-1])
                {
                    dp[j]=dp[j]+ dp[j- coins[i-1]];
                    
                }
            }
            
        }
        return dp[amount];
        
    }
    /*
    //Time Compolexity:  O(n x amount)
   //Space Complexity: O(n x amount)
    
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        // if amount=0 and coins={}
       dp[0][0]=1;
        
        for(int j=1;j<amount+1;j++)
            dp[0][j]=0;
        
        for(int i=1;i<n+1;i++)
        {
            for(int j=0;j<amount+1;j++)
            {
              // if current amount j< coins[i-1]
                if(j< coins[i-1])
                {
                    
                    dp[i][j]=dp[i-1][j];
                }
                else //j>= coins[i-1]
                {
                    dp[i][j]=dp[i-1][j]+ dp[i][j- coins[i-1]];
                    
                }
            }
            
        }
        return dp[n][amount];
        
    }
    */
}