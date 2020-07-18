
// time complexiy of this problem is O(m*n) (time is m*n proportional since we are filling the matrix) and space complexity O(m*n) 
// this program works well
// here we the amount is less than the coin denomination than we take it from above ie already calculated else we are adding the above calculated value and going back to the column by the number of coin denomination and then adding that value to that previous and the  returning the last value of the matrix.
class Solution {
    public int change(int amount, int[] coins) {
        int  [][] dp= new int [coins.length+1][amount+1];
        dp[0][0]=1;
        int r=dp.length; // no of rows
        int c=dp[0].length; // no of columns
        for(int i=1;i<r;i++)
        {
            dp[i][0]=1;
        
        for(int j=1;j<c;j++)
        {
            if(j<coins[i-1])
            {
                dp[i][j]=dp[i-1][j];
            }
            else
                dp[i][j]=dp[i-1][j]+ dp[i][j-coins[i-1]];
        }
        }
       return dp[r-1][c-1];
    }

}