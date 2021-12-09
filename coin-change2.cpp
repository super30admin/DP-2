//Time Complexity : O(amount * coins.size())
//Space complexity : O(amount * coins.size())

//Leetcode : Yes

//Approach:
            //Find number of combinations for each coin and add it to current combinations

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        
        if(coins.empty())
            return 0;
        
        vector<vector<int>> dp(coins.size() + 1, vector<int>(amount + 1, 0));
        
        dp[0][0] = 1;
        
        for(int i = 1 ; i < coins.size() + 1 ; i++)
        {
            for(int j = 0 ; j < amount + 1; j++)
            {
                if(j < coins[i - 1])
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
    
//     int recurse(vector<int>& coins, int amount, int index)
//     {
//         //Write logic
//         if(amount == 0)
//         {
//             return 1;
//         }
//         if(index == coins.size() || amount < 0)
//         {
//             return 0;
//         }
        
//         //Dont choose this coin
//         int case0 = recurse(coins, amount, index + 1);
//         //Choose this coin
//         int case1 = recurse(coins, amount - coins[index], index);
        
//         return case0 + case1;
//     }
};