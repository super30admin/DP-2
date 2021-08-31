// Time Complexity : o(m*n)
// Space Complexity : o(m*n)
// Did this code successfully run on Leetcode : yes 518
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int change(int amount, int[] coins) {
        //dp array of size coins.length+1 and amount +1
        int[][] dp = new int[coins.length+1][amount+1];
        //as we can make amount 0 with coins 1 way so 1
        dp[0][0]=1;
        //as we cant make amount greater than 0 with coins so that row will be 0
        for(int i=1;i<dp[0].length;i++){
            dp[0][i]=0;
        }
        //as we can make amount 0 with coins so that column will be 1
        for(int i=1;i<dp.length;i++){
            dp[i][0]=1;
        }
        //iterate through the array
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                //until amount is less than denomination of coin take right above row
                if(j < coins[i-1]){
                    dp[i][j]=dp[i-1][j];                    
                }
                //when amount is greater than denomination we need to add cause we need total no.of combination so add prev row + 2 steps back
                else{
                    dp[i][j]=dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        //return last element in 2d array
        return dp[dp.length-1][dp[0].length-1];
    }
}