
// Time Complexity : O(coins.size() * amount ) , that is the matrix i created
// Space Complexity : O( coins.size() * amount ) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None



class Solution {
public:
    int change(int amount, vector<int>& coins) {
        int rows = coins.size()+1;
        int cols = amount + 1;
        int matrix[rows][cols];
        memset( matrix, 0, rows*cols*sizeof(int));
        
        for( int i=1; i<rows; i++){
            matrix[i][0] = 1;
        }
        
        for( int i=1; i<rows; i++){
            for( int j=1; j<cols; j++ ){
                if( coins[i-1] > j ){
                    matrix[i][j] = matrix[i-1][j];
                } else {
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j-coins[i-1]]; 
                }
            }
        }
        return matrix[rows-1][cols-1];
    }
};
