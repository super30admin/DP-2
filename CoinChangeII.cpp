// Time Complexity : exponential
// Space Complexity : O(n) where n is the depth of the recursion tree
// Did this code successfully run on Leetcode : No, Time Limit Exceeded

//Recursive exhaustive search approach


class Solution {
private:
    int helper(vector<int>& coins, int amount, int index, int count){
        //base case
        if(amount < 0 || index == coins.size()){
            return 0;
        }
        if(amount == 0)
            return 1;

        //case 0 - we don't pick the coin
        int case1 = helper(coins, amount, index+1, count);

        //case 1 - we pick the coin 
        int case2 = helper(coins, amount-coins[index], index, count);

        //returns 1 only when the base case of amount == 0 is hit 
        //which means that is one way to add up coins to make it amount 
        return (case1 + case2);
    }
public:
    int change(int amount, vector<int>& coins) {
        if(coins.size() == 0)
            return 0;
        return helper(coins, amount, 0, 0);
    }
};


// Approach 2

// Time Complexity : O(m*n) where m is the number of coins and n is the amount 
// Space Complexity : O (m*n)
// Did this code successfully run on Leetcode : Yes



class Solution {
public:
    int change(int amount, vector<int>& coins) {
        if(coins.size() == 0)
            return 0;
        //declaring 2d array of size coins+1 and amount+1 and initialising it to 0
        vector<vector<int>> dp(coins.size()+1, vector<int>(amount+1, 0));

        //the first row is 1
        //i.e, there is 1 way to make amount 0 with the coins - by not picking it 
        for(int j=0; j<coins.size()+1; j++)
            dp[j][0] = 1;
        
        for(int i=1; i<coins.size()+1; i++){
            for(int j=0; j<amount+1; j++){
                //adding the case where we picked the coin and didn't pick the coin 
                //picking the coin would be the same array [1 2 3] with amount reduced by the latest coin
                //if we didn't pick the coin, that would be the array with that coin [1 2] and amount would be the same (same column, 1 row above)
                if(j-coins[i-1]<0)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }
        }
        return dp[coins.size()][amount];
    }
};