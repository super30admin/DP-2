//Coin Change 2
//Time Complexity:O(m*n)
//Space Complexity:O(m*n)
class Solution {
    public int change(int amount, int[] coins) {
        if(coins==null)
        {
            return 0;
        }
        int n=coins.length;
        int m=amount;
        int[][] dp=new int[n+1][m+1];
        dp[0][0]=1;  //one way to make 0 from 0
        //dont fill first row since we have 0 at all places
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {

                if(j<coins[i-1])
                {
                    //not choosing the coin i->same prev coin i-1 is used
                    //case 0 , don't choose
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    //case 1 ,choose
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[n][m];

    }
}