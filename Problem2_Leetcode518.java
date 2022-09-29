// Time Complexity : O(MN) M = No of coins N = amount
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Solution 1:
// Exhaustive approach by checking each combination
// Recursive solution which is not time effective.
// It is just for your reference that this approach also works in small cases
// We can use DP to solve this problem. Check solution 2

// class Solution {
//     public int change(int amount, int[] coins) {
//         if(coins == null || coins.length == 0) return 0;

//         return helper(coins, amount, 0, 0);
//     }

//     private int helper(int[] coins, int amount, int index, int combinations) {

//         if(index >= coins.length || amount < 0)
//             return 0;

//         if(amount == 0){
//             combinations++;
//             return combinations;
//         }

//         // if you do not choose a coin
//         int case1 = helper(coins, amount, index + 1, combinations);

//         // if you not choose a coin
//         int case2 = helper(coins, amount - coins[index], index, combinations);

//         return case1 + case2;
//     }
// }


// Solution 2:
// By creating a dp matrix and generating a formula

class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) return 0;

        int m = coins.length;
        int n = amount;

        // create a matrix as below
        // columns indicate the amount starting from 0 to 5 in case of [1,2,5]
        // and rows indicate type of coins. We will have extra coin with vallue 0 at start, so that our dp formula will work in any case
        // in the matrix we are putting total no of ways we can form a certain amount using coins available

        //            amount
        //           | 0 | 1 | 2 | 3 | 4 | 5 |
        //         ---------------------------
        //         0 |   |   |   |   |   |   |
        // coin    1 |   |   |   |   |   |   |
        //         2 |   |   |   |   |   |   |
        //         5 |   |   |   |   |   |   |
        int[][] dp = new int[m + 1][n + 1];

        // fill 1 in 1st column because to create amount 0, there is always one way which is not to chooose a coin.
        // If you don't choose a coin amount will remain 0.
        // fill 1st row starting from 1 with 0 because you cannot make any amount by choosing or not choosing coin of value 0
        //Our matrix will look as below after this step

        //                  amount
        //           | 0 | 1 | 2 | 3 | 4 | 5 |
        //         ---------------------------
        //         0 | 1 | 0 | 0 | 0 | 0 | 0 |
        // coin    1 | 1 |   |   |   |   |   |
        //         2 | 1 |   |   |   |   |   |
        //         5 | 1 |   |   |   |   |   |
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 1;
        }

        // now we will start filling the matrix from i = 1 and j = 1 because our first row and first column are filled
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {

                // find the actual coin that we are currently on
                int coin = coins[i - 1];

                // if amount that we are trying to form(j) is < coin value
                // then you can just copy the value lying just in above cell
                if(j < coin) {
                    dp[i][j] = dp[i - 1][j];
                }
                else{
                    // else we will take the value lying just above and
                    // value which (coins) cells back
                    // and add both values
                    // this will give us total no of ways to form current amount(j) using available coins
                    int case1 = dp[i - 1][j];
                    int case2 = dp[i][j - coin];
                    dp[i][j] = case1+ case2;
                }
            }
        }

        // after this our matrix will look like this

        //                  amount
        // dp matrix || 0 | 1 | 2 | 3 | 4 | 5 |
        //         ---------------------------
        //         0 || 1 | 0 | 0 | 0 | 0 | 0 |
        // coin    1 || 1 | 1 | 1 | 1 | 1 | 1 |
        //         2 || 1 | 1 | 2 | 2 | 3 | 3 |
        //         5 || 1 | 1 | 2 | 2 | 3 | 4 |

        // we can find the max no of ways to form our amount from the very last cell
        return dp[m][n];
    }
}