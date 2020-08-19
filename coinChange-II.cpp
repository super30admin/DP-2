// Time Complexity : O(2^n) //  choose/don't choose
// Space Complexity : O(m+n) // recursive stack; m=amount, n-number of coins
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// [***] KEY INSIGHT: EACH POINT - TWO OPTIONS; WHEN AMT REACHES ZERO INC COUNT; 
// [***] NOTE: CHECK IF AMOUNT BECOMES NEGATIVE AND NOT IF AMOUNT-COINS[INDEX] < =


// Your code here along with comments explaining your approach
// 1. Recursive solution - call recursive function initially with 0 count
// 2. Each step, we either choose the current coin or dont
// 3. If amount becomes negative or index goes out of bounds, just return.If amount beomces 0 increase count

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        if(amount == 0)
            return 1;
        if(coins.size() == 0)
            return 0;
        int count = 0;
        dfs(coins, amount, 0, count);
        return count;
    }
    
    void dfs(vector<int>& coins, int amount, int index, int& count){
        // base
        if(amount == 0){
            count++;
            return;
        }
        if(index>=coins.size() || amount<0)
            return;
        
        // logic
        // choose
        dfs(coins, amount-coins[index], index, count);
        // don't choose
        dfs(coins, amount, index+1, count);
    }
};

// DP Solution
// Time Complexity : O(mn) //  choose/don't choose
// Space Complexity : O(mn) // m=amount, n-number of coins
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// [***] KEY INSIGHT: EACH ELEMENT = SUM OF ELEMENT ABOVE (===DON'T CHOOSE) AND ELEMENT AT SAME ROW BUT COLUMN-DENOMINATION (===CHOOSE)

// Your code here along with comments explaining your approach
// 1. Cache matrix with row and column for 0 amount and 0 coins
// 2. If amount is less than denomination implies take from above (dont choose denomination)
// 3. Else value is sum of above val (corr to dont choose denomination) and val at same row and column-denomination (corr to choose denomination)

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        if(amount == 0)
            return 1;
        if(coins.size() == 0)
            return 0;
        vector<vector<int>> cache(coins.size()+1, vector<int>(amount+1,0));
        int m = cache.size(), n=cache[0].size();
        
        // first row = 0 since no coins
        for(int j=0;j<n;j++)
            cache[0][j] = 0;
        // first col = 1 since amount is 0; let first el become 1; case is 0 amount n 0 coins
        for(int i=0;i<m;i++)
            cache[i][0] = 1;
        
       for(int i=1;i<m;i++){
           for(int j=1;j<n;j++){
               if(j<coins[i-1])
                   cache[i][j] = cache[i-1][j];
               else
                   cache[i][j] = cache[i-1][j] + cache[i][j-coins[i-1]];
           }
       } 
        return cache[m-1][n-1];
    }
};