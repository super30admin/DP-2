// Time complexity is O(rows*columns) - rows = size of coins array + 1; columns = amount + 1
// Space complexity is O(rows*columns)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach:
/*
    1. 'res' 2-D array is created. We store the number of combinations of different coins that make up that amount.
 */

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        int rows = coins.size()+1;
        int columns = amount+1;
        vector<vector<int>> res(rows, vector<int>(columns, 0));
        
        for(int i = 0; i < rows; i++)
            res[i][0] = 1;
        
        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < columns; j++) {
                if(j < coins[i-1])
                    res[i][j] = res[i-1][j];
                else
                    res[i][j] = res[i-1][j] + res[i][j-coins[i-1]];
            }
        }
        return res[rows-1][columns-1];
    }
};


// Recursive Solution
class Solution {
public:
    int recursiveFn(vector<int> coins, int amount, int index) {
        //base case
        if(amount == 0) return 1;
        if(index == coins.size() || amount < 0) return 0;
        //logic
        //Don't choose coin at index
        int case1 = recursiveFn(coins, amount, index+1);
        
        //Choose coin at index
        int case2 = recursiveFn(coins, amount-coins[index], index);
        
        return case1 + case2;
    }
    int change(int amount, vector<int>& coins) {
        return recursiveFn(coins, amount, 0);
    }
};
