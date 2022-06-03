
// Time Complexity : O(costs.size() * colors( num = 3) ) , that is the matrix i created
// Space Complexity : O( costs.size() * colors( num = 3) ) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        int colors = 3;
        int cols = colors;
        int rows = costs.size() + 1;
        int matrix[rows][cols];
        memset( matrix, 0, rows*cols*sizeof(int));
        for( int j=0; j<cols; j++){
            matrix[1][j] = costs[0][j];
        }
        
        for( int i=2; i<rows; i++){
            for( int j=0; j<cols; j++){
                matrix[i][j] = costs[i-1][j];
                if( j == 0 ){
                     matrix[i][j] += min( matrix[i-1][1], matrix[i-1][2]);
                } else if ( j == 1){
                     matrix[i][j] += min( matrix[i-1][0], matrix[i-1][2]);
                } else {
                     matrix[i][j] += min( matrix[i-1][0], matrix[i-1][1]);
                }
            }
        }
        int mini = INT_MAX;
        for( int j = 0; j<cols; j++){
            mini = min( mini, matrix[rows-1][j] );
        }
        return mini;
    }
};
