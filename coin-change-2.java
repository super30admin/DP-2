
//Time Complexity: O(n ^ 2)
//Space Complexity: O(amount+1) [Creating a dp array of size which equals amount+1]
//Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        int dp [] =new int [amount+1];
        dp [0] = 1;
      
        for(int i = 0; i < coins.length; i++){
            for(int j=coins[i];j < dp.length;j++){
                int remainder = j - coins[i];
                dp[j] += dp[remainder] ;
                
            }
        }
        return dp[dp.length-1];
        
    }
}