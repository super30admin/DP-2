// TC= O(m x n)
// SC= O(n)

class Solution {
    public int change(int amount, int[] coins) {
        //null case
        if(coins==null || coins.length==0) return 0;

        int m= coins.length;
        int n= amount;
        int dp[]= new int[n+1];
        dp[0]=1;

        for(int i=1;i<=m; i++)
        {
            for(int j=0;j<=n; j++)
            {
                //not choose case
                if(j< coins[i-1])
                    dp[j]=dp[j];
                else //choose case
                    dp[j]= dp[j] + dp[j-coins[i-1]];
            }
        }
        return dp[n];
    }
}