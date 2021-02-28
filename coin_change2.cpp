// Time Complexity: O(N*k)Where N is the size of coin vector and k is the amount;
// Space Complexity: O(N*k) Where N is the size of coin vector and k is the amount;
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


class Solution {
public:
    int change(int amount, vector<int>& coins) {
        int rows = coins.size()+1;
        int cols = amount+1;
        int t[rows+1][cols+1];
        
        for(int i = 0; i < cols;i++)t[0][i] = 0;
        for(int i = 0; i < rows; i++)t[i][0] = 1;
        for(int i = 1; i < rows;i++){
            for(int j = 1; j< cols;j++){
                if(coins[i-1]<=j){
                    t[i][j] = t[i][j-coins[i-1]]+t[i-1][j];
                }
                else t[i][j] = t[i-1][j];
            }
        }
        return t[rows-1][cols-1];
        
    }
};