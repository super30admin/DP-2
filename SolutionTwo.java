// Time Complexity : O(n*m) m=amount n=no of coins
// Space Complexity : O(m) but still not sure about this
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : nopes

class SolutionTwo {
    public int change(int amount, int[] coins) {

        if(coins==null)
            return 0;

        int [][]dp= new int[coins.length+1][amount+1];

        for(int j=0;j<dp.length;j++)
        {
            dp[j][0]=1;
        }

        for(int i=1;i<dp.length;i++)
        {
           for(int j=1;j<dp[0].length;j++)
           {
               if(j<coins[i-1])
               {
                   dp[i][j]=dp[i-1][j];
               }
               else
               {
                   dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
               }
           }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
}