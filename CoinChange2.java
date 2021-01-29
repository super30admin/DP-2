package S30.DP2;


/* Successfully executed on leetcode
*  Time complexity: Since two for loops are used to iterate over coins (n is number of coins) and amount to calculate
*                   total ways from 0 to amount (m is amount), it is O(n*m)
*  Space Complexity: Using matrix to store total ways of change for every amount from 0 to amount so
*                    O(n*m)
*
* Approach: finding total number of ways from 0 to amount and by considering 1 coin at a time.
*           Building matrix with total ways which will be helpful for while considering more coins
*           Followed count and don't count method.
* */

public class CoinChange2 {
    public static void main(String args[]){
        int[] coins = {1,2,5};
        int amount = 5;
        System.out.print(change(amount,coins));
    }

    public static int change(int amount, int[] coins) {
        int[][] changeMatrix = new int[coins.length+1][amount+1];
        for(int i=0; i<coins.length+1; i++){
            changeMatrix[i][0] = 1;
        }

        for(int j=1; j<amount+1; j++){
            changeMatrix[0][j] = 0;
        }

        for(int i=1; i<coins.length+1; i++){
            for(int j=1; j<amount+1; j++){
                if(j < coins[i-1])
                    changeMatrix[i][j] = changeMatrix[i-1][j];

                else
                    changeMatrix[i][j] = changeMatrix[i][j-coins[i-1]]+changeMatrix[i-1][j];
            }
        }
        return changeMatrix[coins.length][amount];
    }
}
