// 518. Coin Change II
// Time Complexity : O(m * n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
    
Initializes a DP array dp of size n + 1, where n is the amount, setting dp[0] to 1 to represent there is one way to make
up the amount of 0 (by using no coins). Then, iterates through each coin denomination, updating the dp array to count the 
number of combinations for each amount, considering the current coin denomination. Finally,returns the count of combinations 
stored in dp[n], representing the total number of ways to make up the given amount using the provided coins.

*/

int change(int amount, vector<int>& coins) {
    int m = coins.size(), n = amount;
    int dp[n+1];
    dp[0] = 1;
    for(int i = 1; i < n+1; i++)
        dp[i] = 0;
    for(int i = 0; i < m; i++)
    {
        for(int j = 1; j < n+1; j++)
        {
            if(j < coins[i])
                continue;
            dp[j] = dp[j] + (dp[j-coins[i]]);
        }
    }
    return dp[n];
}
