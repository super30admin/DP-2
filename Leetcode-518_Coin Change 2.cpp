// Time Complexity : O(N*M) where N = amount+1, M = coins.size()+1
// Space Complexity :  O(N*M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
1. Come up with recursive solution
2. Build up dp table
3. return the result
*/

class Solution
{
public:
    int change(int amount, vector<int>& coins)
    {
        vector<vector<int>>dp(coins.size() + 1, vector<int>(amount + 1, 0));

        for (int i = 0; i < coins.size() + 1; i++)
            dp[i][0] = 1;

        for (int i = 1; i < coins.size() + 1; i++)
        {
            for (int j = 1; j < amount + 1; j++)
            {
                // case where element in coins array is greater than sum
                if (coins[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]; // excluding and including current coin
            } 
        }

        return dp[coins.size()][amount];
    }

};


//recursive colution

// Time Complexity : O(2^M)
// Space Complexity :  O(2^M) - stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
    /* 
    int change(int amount, vector<int>& coins)
    {
        //base case
        if(amount == 0)
            return 1;

        if(coins.size()==0 && amount>0)
            return 0;


        return findchange(amount, coins, coins.size()-1);


    }


    int findchange(int amount, vector<int> & coins, int index)
    {

        //base case

        if(amount==0)
            return 1;

        if(amount<0 || index <0 )
            return 0;

        // logic
        return  findchange(amount, coins, index-1) + findchange(amount- coins[index], coins, index);

    } */
