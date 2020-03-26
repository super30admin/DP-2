// Time Complexity :O(mxn) where m is number of coin and n is amount
// Space Complexity :O(mxn) for mxn matrix
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : Figuring out the dp pattern


// Your code here along with comments explaining your approach

class coinChange2 {
    public static int change(int amount, int[] coins) {
        //edge case
        if(amount==0) return 1;
        if(coins.length==0) return 0;
        int [][] dp= new int[coins.length+1][amount+1];
        for(int i =0;i<=coins.length;i++)
        {
            dp[i][0]=1;
        }
        
        for(int i = 1;i<=coins.length;i++)
        {
            for(int j =1;j<=amount;j++)
            {
                if(j<coins[i-1]) dp[i][j]= dp[i-1][j];
                else dp[i][j]= dp[i-1][j] + dp[i][j-coins[i-1]];
            }
        }
        return dp[coins.length][amount];
    }
    public static void main(String[] args)
    {
        System.out.println(change(6, new int[]{1,2,5}));
    }
}