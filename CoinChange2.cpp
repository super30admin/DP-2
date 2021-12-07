// Time Complexity : O(coins.length * amount)
// Space Complexity : O(coins.length * amount)
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
/* Create a 2d array where rows represent the coins available and columns represents amounts.
 * Each cell represents the number of ways to create a column amount using coins of current and above rows. 
 * For each cell compute the ways to get a column amount by adding the number of ways present in above row for the same value 
 *     and number of ways available to get the (current amount - current coin value) in the same row. 
 */

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        if (coins.size() == 0)
            return 0;
        
        int dp[coins.size() + 1][amount + 1];
        
        // First 0th row initialization
        
        for (int i = 0; i <= amount; i++)
            dp[0][i] = 0;
        
        // First column initialization
        
        for (int j = 0; j <= coins.size(); j++)
            dp[j][0] = 1;
        
        for (int i = 1; i <= coins.size(); i++)
        {
            for (int j = 1; j <= amount; j++)
            {
                if (j < coins[i - 1])
                {
                    dp[i][j] = dp[i - 1][j];
                }
                else
                {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        
        return dp[coins.size()][amount];
    }
};