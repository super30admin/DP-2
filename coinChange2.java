// Time Complexity:  O(m x n) where n is the amount and m is number of denomination of coins given
// Space Complexity: O(m x n)

class Solution {
    public int change(int amount, int[] coins) {
        int[][] matrix = new int[coins.length+1][amount+1];
        matrix[0][0] = 1;
        
        for(int i=0; i < matrix.length; i++){
            matrix[i][0] = 1;
        }
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                
                if(j < coins[i-1]){
                    matrix[i][j] = matrix[i-1][j];
                } else {
                    matrix[i][j] = matrix[i][j - coins[i-1]] + matrix[i-1][j];
                }
            }
        }
        
        return matrix[matrix.length-1][matrix[0].length-1];
    }
}