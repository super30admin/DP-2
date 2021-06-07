// Time Complexity : O(m*n)
// Space Complexity :  O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this - 
class Solution {
public:
    int change(int amount, vector<int>& coins) {
        
        int len = coins.size();
        int i, j;
        
        int lookup[len+1][amount+1];
        
        //Set the values to 0 or 1 for the first row, column
        for(i = 0; i <= len; i++)
        {
            for(j = 0; j <= amount; j++)
            {
                if(i == 0)
                    lookup[i][j] = 0;
                
                if(j == 0)
                    lookup[i][j] = 1;
            }
        }
        
        for(i = 1; i <= len; i++)
        {
            for(j = 1; j <= amount; j++)
            {
                if(coins[i-1] <= j)
                    lookup[i][j] = lookup[i-1][j] + lookup[i][j-coins[i-1]];
                else
                    lookup[i][j] = lookup[i-1][j];
            }
        }
        return lookup[len][amount];
    }
};