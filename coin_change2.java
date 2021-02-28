// Time Complexity : O(N*M) , n is coins array length, m is amount
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        
        //TC : O(n*m)
        //SC : O(n*m)
        if(amount==0) return 1;
        
        int rows = coins.length+1;
        int columns = amount+1;
        
        int dp[][] = new int[rows][columns];
        
        for(int i=1;i<columns;i++){
            dp[0][i]=0;
        }
        
        for(int i=0;i<rows;i++){
            dp[i][0]=1;
        }
        
        for(int i=1;i<rows;i++){
            for(int j=1;j<columns;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];//DC
                }
                else{
                    dp[i][j] = dp[i-1][j]+(dp[i][j-coins[i-1]]); //C+DC
                }
            }
        }
        
        return dp[rows-1][columns-1];
    }
}
