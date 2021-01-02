// Time Complexity : The time complexity is O(m) where m is the amount.
// Space Complexity : The spave complexity is O(m) where m is the amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {

        if(amount == 0){
            return 1;
        }

        if(coins.length == 0){
            return 0;
        }

        // Array which stores the number of combinations for each amount
        int[] dp = new int[amount+1];
        dp[0] = 1;

        for(int coin:coins){

            // Number of coins for each amount
            for(int i=coin;i<dp.length;i++){
                dp[i] += dp[i-coin];
            }

        }

        return dp[amount];

    }
}


// Time Complexity : The time complexity is n^m where n is the number of coins and m is the amount.
// Space Complexity : The space complexity is O(m) where m is the amount since an internal stack is used for recursive calls
// Did this code successfully run on Leetcode : No(Time Limit Exceeded)
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {

    int count = 0;

    public int change(int amount, int[] coins) {

        recursive(amount,coins,0);

        return count;

    }

    public void recursive(int amount,int[] coins,int index){

        if(amount == 0){
            count++;
        }

        // Number of different combinations for the current amount
        for(int i=index;i<coins.length;i++){

            if(amount-coins[i] >= 0){
                recursive(amount-coins[i],coins,i);
            }

        }

        return;

    }
}