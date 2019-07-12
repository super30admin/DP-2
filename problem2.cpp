// Time Complexity : O(m *n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No problem. 


// Your code here along with comments explaining your approach


#include <iostream>
#include <vector>

using namespace std;

class Solution {
    public:
        int change(int amount, int[] coins) {
        int dp[coins.length+1][amount+1];

        dp[0][0] = 1;

        for(int i =1; i<coins.length+1; i++)
            dp[i][0] = 1;

        for(int i =1; i<coins.length+1;i++)
            for(int j =1; j<amount+1 ; j++)
            {
                if(j<coins[i-1])
                    dp[i][j] =  dp[i-1][j] + 0; 
                else  
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
            }

        return dp[coins.length][amount];
    }
}; 