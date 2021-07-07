//Time complexity : O(mn) m->number of different coins n->amount
//Space Complexity: O(mn) 

// Instead of taking the minimum values, we will add the upper element with the element at (amount - coins[index]).
//The matrix will be somewhat like this .

//for the test input [1 2 5] and amount =5
//     0   1   2   3   4   5
// 0   1   0   0   0   0   0

// 1   1   1   1   1   1   1

// 2   1   1   2   2   3   3

// 5   1   1   2   2   3   4

class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null) return 0;
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<dp[0].length;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}