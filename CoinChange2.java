// Time Complexity :O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        
        int[][] dp = new int[coins.length+1][amount+1];
        
        for(int i=0;i<=coins.length;i++){
            dp[i][0]=1;
        }
        for(int j=1;j<=amount;j++){
            dp[0][j]=0;
        }
        
        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
    
}
