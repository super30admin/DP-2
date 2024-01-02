//518. Coin Change II


/*
Greedy doesn't work always, exhaustive TLE
Do DP, extension of coin change 1

Time Complexity: O(number of coins * Amount)
Space Complexity: O(n)

*/
class Solution {
public:
    /*
    int helper(vector<int> &coins, int amount, int idx){
        //base
        if(amount == 0) return 1; //cause valid case
        if(amount<0 || idx == coins.size()) return 0;

        //logic
        //when chosen
        int case1 = helper(coins, amount-coins[idx], idx);
        //not choosen
        int case2 = helper(coins, amount, idx+1);

        return case1+case2; //gives total number of possible ways    
    }
    */

    int change(int amount, vector<int>& coins) {
        /*
        //exhaustive - time limit exceeds
        if (coins.size()==0) return 0;
        return helper(coins, amount,0);
        */


        /*
        //tabulation
        int m=coins.size(), n = amount;
        vector<vector<int>> dp(m+1, vector<int>(n+1));
        dp[0][0] = 1;

        for(int i=1; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(j <coins[i-1])
                dp[i][j] = dp[i-1][j];
                else
                dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }
        }
        
        return dp[m][n];

        */
        //space optimization
        int m=coins.size(), n = amount;
        vector<int> dp(n+1);
        dp[0] = 1;

        for(int i=1; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(j <coins[i-1])
                dp[j] = dp[j];
                else
                dp[j] = dp[j] + dp[j-coins[i-1]];
            }
        }
        
        return dp[n];
    }
};