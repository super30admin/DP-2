// Time Complexity :O(n*m)
// Space Complexity :O(n*m)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*

We create a 2d matrix to represent the DP, the coulmns is comprised of the amount + 1 dummy
coulumn for 0, and the rows are representing the number of different coins.

while iterating thorugh the matix, we will first check if the amount is less than the 
denomination, if thats the case then we will just add the number of ways from the 
previous coin as we dont have any more new ways to get to the amount.

If the amount is greate than the denomination, we add the previous rows(number of ways) 
and the number of ways to get to the amount from the current coin that is amount - denomination.

we then return the last element of the matrix.



*/


// Your code here along with comments explaining your approach


#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int change(int amount, vector<int>& coins) {

        if(coins.size()==0){
            return 0;
        }

        int m = amount;
        int n = coins.size();

        vector<vector<int>> dp(n+1,vector<int>(m+1,0));

        dp[0][0]=1;

        

        for(int i=1;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
            
        }



        return dp[n][m];



        
    }
};