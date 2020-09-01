// Time Complexity : O(coins_length+1 * amount+1)
// Space Complexity : O(coins_length+1 * amount+1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


//We create a 2D array with number of columns as amount and number of coins as rows. 
//Fill the first column with 1s. The no of ways to get '0' with any coin is 1 i.e., we do not choose the coin. 
//The number of ways to reach amount > 0 by using 0 is zero.  
//Calculate the number of ways to reach the amount by considering each coin. 
//It is obtained by sum of Choose coin + Dont Choose coin. It is arr[amount-coin]+arr[previous_row][column]
//The total no of ways is the last element of array.

public class CoinChange2 {

    public static int change(int amount, int[] coins) {
        int[][] result = new int[coins.length+1][amount+1];
        for(int i=0; i< result.length; i++){
            result[i][0]=1;
        }
        for(int i=1; i < result.length; i++){
            for(int j = 1; j <= amount; j++){
                if(j < coins[i-1]){
                    result[i][j] = result[i-1][j];
                }else{
                    result[i][j] = result[i][j - coins[i-1]] + result[i-1][j];
                }
            }
        }
        return result[coins.length][amount];
    }

    public static void main(String[] args){
        int[] arr = {10};
       System.out.println(change(10,arr));
    }

}