Time Complexity-O(amount*coins)
Space Complexity-O(amount * coins)

class Solution {
    public int change(int amount, int[] coins) {
        if(coins==null)
            return 0;
        int m=coins.length+1;
        int n=amount+1;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++)
            dp[i][0]=1;
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(coins[i-1]>j)
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
            }
        }
        return dp[m-1][n-1];
            
        
    }
}
