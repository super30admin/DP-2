// (Approach 1) 
// Time Complexity : O(n * m)  
//                   ...  n is number of different types of coins
//                   ...  m is amount
// Space Complexity :  O(n * m)  
//         
// (Approach 2) 
// Time Complexity : O(n * m)  
//                   ...  n is number of different types of coins
//                   ...  m is amount
// Space Complexity :  O(m)  ..... resuced due to use of 1-D array           
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leet code : https://leetcode.com/problems/coin-change-2/

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
You may assume that you have an infinite number of each kind of coin.
The answer is guaranteed to fit into a signed 32-bit integer.
*/


/*
Approach 1 : Using 2-D array
*/

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        int n = coins.size();
        vector<vector<int>>arr(n+1, vector<int>(amount+1, 0));

        for(int i = 0; i<= n; i++){
            arr[i][0] = 1;
        }

        for(int i = 1; i <= n; i++){
            int coin = coins[i-1];
            for(int j = 1; j<=amount; j++){
                if(j < coin) {
                    arr[i][j] = arr[i-1][j];
                } else {
                    arr[i][j] = arr[i-1][j] + arr[i][j-coin];
                }
            }
        }

        return arr[n][amount];
    }
};


/*
Approach 2 : Using 1-D array
*/

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        int n = coins.size();
        vector<int> arr(amount+1, 0);
        arr[0] = 1;

        for(int i = 1; i <= n; i++){
            int coin = coins[i-1];
            for(int j = 1; j<=amount; j++){
                if(j >= coin) {
                    arr[j] = arr[j] + arr[j-coin];
                }
            }
        }
        return arr[amount];
    }
};