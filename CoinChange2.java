// Time Complexity : O(n*m) where  n = amount and n = no. of coins
// Space Complexity : O(n*m) where  n = amount and n = no. of coins
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*Approach
 * We are using the DP approach. We create a matrix where rows representing coins and columns as amount starting from 0 to amount
 * each value in the matrix is maximum ways the jth amount can be reach using 0-i th coins
 * */

public class CoinChange2 {

    public int change(int amount, int[] coins){
        //edge case
        if(coins==null) return 0;

        int mat[][] = new int [coins.length+1][amount+1];

        //insert the row for amount 0
        for(int i=0; i<mat.length; i++){
            mat[i][0] = 1;
        }

        for(int i=1; i<mat.length; i++){
            for (int j=1; j<mat[0].length; j++){
                if(j<coins[i-1]){
                    mat[i][j] = mat[i-1][j];
                }
                else {
                    mat[i][j] = mat[i-1][j] + mat[i][j - coins[i-1]];
                }
            }
        }

        return mat[mat.length-1][mat[0].length-1];
    }
}
