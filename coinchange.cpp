//Time Complexity-O(n*m)
//HSpace Complexity-O(n)
//Did the code run on Leetcode? Yes

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        vector<int>dp(amount+1,0);
        dp[0]=1;
        for(auto x:coins)
        {
            for(int i=x;i<=amount;i++)
            {
                dp[i]=dp[i]+dp[i-x];
            }
        }
        return dp[amount];
    }
};
