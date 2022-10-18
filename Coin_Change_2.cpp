/*
Time Complexity: O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode :yes
Any problem you faced while coding this : no
*/
class Solution {
public:
    int change(int amount, vector<int>& coins) {
        int ans;
        vector<vector<int>> dp(coins.size(), vector<int>(amount + 1, -1));
        
        return ans = ch(amount,coins, 0, dp);
    }
    int ch(int amount, vector<int>& coins, int index, vector<vector<int>>& dp){
        //base
            //valid
            if(amount==0) return 1;
            //invalid
            if(amount<0||index==coins.size()) return 0;
        //recursive
            //select
            if(dp[index][amount]==-1){
            int sel = ch(amount-coins[index], coins, index, dp);
            //notselect
            int notsel = ch(amount, coins, index+1, dp);
            dp[index][amount] = sel + notsel;
            }
        return dp[index][amount];
    }
};