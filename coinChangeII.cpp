//time complexity:O(n)
//space complexity:O(n)
//executed on leetcode: yes
//approach:using dp
//any issues faced? no
class Solution {
public:
    int change(int amount, vector<int>& coins) {
        int memo[coins.size()][amount+1];
        return helper(amount, coins, 0, memo);
    }
    int helper(int amount, vector<int>&coins, int index, int& memo[][])
    {
        if(index>=coins.size())
            return 0;
        if(amount==0)
            return 1;
        if(memo[index][amount]!=NULL)
            return memo[index][amount];
        
        int way1=0;
        if(amount>=coin[index])
            way1=helper(amount-coin[index],coins,index,memo);
        
        int way2=helper(amount,coins,index+1,memo);
        memo[index][amount]=way1+way2;
        return way1+way2;
        
    }
};