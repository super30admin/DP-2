// Time Complexity : O((coins.length) * (amount))
// Space Complexity : O((coins.length) * (amount))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Optimized solution involves handling the edge cases in the first row and column, and populating the matrix with the sum of value of one element above and the element in the (row - coin)th row

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        if(coins == null) return 0;
    
        int[][] matrix = new int[coins.length + 1][amount + 1];
        
        for(int i = 1; i < matrix[0].length; i++){
            matrix[0][i] = 0;
        }
        for(int i = 0; i < matrix.length; i++){
            matrix[i][0] = 1;
        }
        
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(j < coins[i-1]){
                    matrix[i][j] = matrix[i-1][j];
                } else{
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j - coins[i-1]];;
                }          
            }
        }
        return matrix[matrix.length-1][matrix[0].length-1];
    }
}

