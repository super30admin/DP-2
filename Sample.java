// Time Complexity :O(n)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : issues in the loop


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        //idea:Take bottom up approach,on first step the take individual values and check with amount
        //break down into next step i.e take current value + previous sum
        
        //if(coins==null || coins.length==0) return 0;
        //initialize dp
        int[] dp = new int[amount+1];
        //if first element is equal to amount
        dp[0]=1;
        
        for( int i:coins){
            for(int j=i; j<=amount; j++){
                dp[j]+= dp[j-i];
            }
        }
        return dp[amount];
    }
}