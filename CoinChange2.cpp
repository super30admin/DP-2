//Time Complexity O(numberOfCoins*amount)
//Space Complexity O(numberOfCoins*amount)

// Problem successfully compiled on leetcode
// No Problems faced while figuring out the logic

#include<vector>
#include<iostream>
using namespace std;

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        
        int dp[coins.size()+1][amount+1];
        for(int i=0;i<=coins.size();i++)
        {
            dp[i][0]=1;
        }
        for(int j=1;j<=amount;j++)
        {
            dp[0][j]=0;
        }
        
        
        
        for(int i=1;i<=coins.size();i++)
        {
            for(int j=1;j<=amount;j++)
            {
                if(j<coins[i-1])
                {
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];
                }
            }
        }
        return dp[coins.size()][amount];
    }
};