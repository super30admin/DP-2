// Coins Change 2

// Time Complexity : O(n * m) where m is the amount and n is the coins denomination
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes, it successfully ran on leetcode.
// Any problem you faced while coding this : Did have to watch the video again in order to correctly implement this.


// Your code here along with comments explaining your approach

#include<bits/stdc++.h>
using namespace std;


class Solution {
public:
    int change(int amount, vector<int>& coins) {
        if(coins.size() == 0) return 0;
        vector<vector<int>> dp(coins.size() + 1, vector<int> (amount+1));   // initialising the 2D array
      
        for(int i = 1; i<dp.size(); i++){
            dp[i][0] = 1;               // filling the first column with 1
        }
        
        for(int i=1; i<dp.size(); i++){
            for(int j=1; j<dp[0].size(); j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];    // till the jth index is less than the denomination of coins it is = previous row
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];  // the total number of ways in both the 0th case and 1 case
                }
            }
        }
        return (dp[dp.size() - 1][dp[0].size()-1]);  // return last row and column which contains the min number of ways we get the amount
    }
};


/* RECURSIVE SOLUTION - TLE
class Solution {
public:
    int change(int amount, vector<int>& coins) {
        if(coins.size() == 0) return 0;
        return helper(coins, amount, 0);
    }
    
    int helper(vector<int>& coins, int amount, int index)
    {
        // base Case
        if(amount == 0) return 1;
        if(amount<0 || index==coins.size()) return 0;
        
        // Logic
        
        // Case1 (Choose a coin)
        int case1 = helper(coins, amount-coins[index], index);
        // Don't Choose a count
        int case2 = helper(coins, amount, index+1);
        
        return case1 + case2;
    }
};

*/
// int main(){
    
//     return 0;
// }