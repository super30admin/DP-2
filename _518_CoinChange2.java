// space complexity - o(n)
    	//time - o(n)
      //Ran on leeetcode successfully : Yes
      // Problem faced  : No
    	//Approach : linear memuization

class Solution {
    public int change(int amount, int[] coins) {

        if(amount == 0 ) return 1;
        if(coins == null || coins.length == 0 ) return 0;

        int[][] matrix  = new int[coins.length+1][amount+1];

        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){

                if(i == 0 || j == 0 ) {
                   matrix[i][j] = 0;
                }
                else if( j < coins[i-1]){
                    matrix[i][j] = matrix[i-1][j];
                }
                else if( j == coins[i-1]){
                    matrix[i][j] = 1 + matrix[i-1][j];
                }
                else if( j >= coins[i-1]){
                    int excludeCurrCoin = matrix[i-1][j];
                    int includeCurrCoin = matrix[i][j -coins[i-1]];
                    matrix[i][j] = excludeCurrCoin + includeCurrCoin;
                }
            }
        }

        return matrix[coins.length][amount];

    }
}
