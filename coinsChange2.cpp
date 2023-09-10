//time complexity: O(coins.size() * amount)
//space complexity: O(coins.size() * amount)
class Solution {
public:
    int change(int amount, vector<int>& coins) {
        //declare a dp 2d array
        vector<vector<int>> dp(coins.size()+1, vector<int>(amount+1));
        //initialize or populate 0th row

        for(int i=0;i<coins.size()+1;++i)
        {
            dp[i][0]=1; //populate first column 
            //start populating dp array
        }
        for(int i=0;i<amount+1;++i)
        {
            dp[0][i]=0; //populate row 0 with os
        }

        //start from second row and second column
        //to populate the array. if your j which is nothing 
        //but sum or amount is less than coins[index] that
        // we have, then simply copy the values from above
        // or else add amount from above to the count-> 
        for(int i=1; i<coins.size()+1; ++i)
        {
            for(int j=1; j<amount+1;++j)
            {
                if(j<coins[i-1])
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
            }
        }
        return dp[coins.size()][amount];
    }
};