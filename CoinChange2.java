import java.util.*;

//Time Complexity : O(c*amount) c=total coins 
//Space Complexity : O(amount) we declare an array to fit the value of element as amount
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    public int change(int amount, int[] coins) {
        int dp[]=new int[amount+1];
        dp[0]=1;
        for(int coin:coins){
            for(int j=coin;j<=amount;j++){
                dp[j]+=dp[j-coin];
            }
        }
        return dp[amount];
    }
}
