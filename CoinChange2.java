//TC is O(m*n)
//SC is O(n)
//NOTE: Approach in Interviews:
//1. Show the exhaustive approach if allowed to use white board.
//2. Start to put out tabulation draw 2D matrix and fill it

// Approach5 : Identify repeated sub problems
// Matrix datastructure to be used for tabulation based on the decision making parameters
// Identify the number of decision making parameters
// optimize with a "1D array"

//TC is O(m*n)
//SC is O(m*n)
class Solution {
    public int change(int amount, int[] coins) {
        //parameters: coins and amount range(0-11)   
        int m = coins.length;
        int n = amount;

        int[] dp = new int[n+1];       

        dp[0] = 1;

        for(int i=1; i<=m; i++){ //i represents denomination of coins
            for(int j=0; j<=n; j++){ //j specifies amount
                if(j < coins[i-1]){
                    dp[j] = dp[j]; //only no choose case - comes from straight above.
                } else{
                    dp[j] = dp[j] + dp[j-coins[i-1]]; // sum of no choose case + choose case(available at amount - denomination place; video 2:25)
                }
            }
        }

        return dp[n];      
    }
}

// // Approach4 : Identify repeated sub problems
// // Matrix datastructure to be used for tabulation based on the decision making parameters
// // Identify the number of decision making parameters
// // start with a DP 2D matrix and later optimize with a 1D array

// //TC is O(m*n)
// //SC is O(m*n)
// class Solution {
//     public int change(int amount, int[] coins) {
//         //parameters: coins and amount range(0-11)   
//         int m = coins.length;
//         int n = amount;

//         int[][] dp = new int[m+1][n+1];       

//         dp[0][0] = 1;

//         for(int i=1; i<=m; i++){ //i represents denomination of coins
//             for(int j=0; j<=n; j++){ //j specifies amount
//                 if(j < coins[i-1]){
//                     dp[i][j] = dp[i-1][j]; //only no choose case - comes from straight above.
//                 } else{
//                     dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]; // sum of no choose case + choose case(available at amount - denomination plae video 2:25)
//                 }
//             }
//         }

//         return dp[m][n];      
//     }
// }


// Approach3 : INT based recursionExhaustive approach/exploring all the ways/BruteForce Approach
// Exceeding time limit because exponentially increasing time complexity
// class Solution {
//     int count; //this is global scope
//     public int change(int amount, int[] coins) {
//         //int[] count = new count[];                 
//         // this.count = 0;
//         return helper(coins,0, amount);
//         // return count;   
//     }
//     private int helper(int[] coins, int i, int amount){
//         //base case
//         if(amount == 0 ){
//             // count++;
//             return 1;
//         }
//         if(amount<0 || i == coins.length) return 0;

//         //dont choose scenario
//         int case0 = helper(coins, i+1, amount); //moving to next coin, amount remains same since not choosing any coin

//         //choose scenario
//         int case1 = helper(coins, i, amount-coins[i]); // remains at the sane coin, amount should be deducted 

//         return case0 + case1;
//     }
// }

// // Approach 2 : Exhaustive approach/exploring all the ways/BruteForce Approach
// // Exceeding time limit because exponentially increasing time complexity
// class Solution {
//     // int count; //this is global scope
//     public int change(int amount, int[] coins) { //coins is primitive data type
                         
//         // this.count = 0;
//         int[] count = new int[1];
//         helper(coins, 0, amount, count);
//         return count[0]; 

//     }
//     private void helper(int[] coins, int i, int amount, int[] count){
//         //base case
//         if(amount == 0 ){
//             count[0]++;
//             return;
//         }
//         if(amount<0 || i == coins.length) return;

//         //dont choose scenario
//         helper(coins, i+1, amount, count); //moving to next coin, amount remains same since not choosing any coin

//         //choose scenario
//         helper(coins, i, amount-coins[i], count); // remains at the sane coin, amount should be deducted 
//     }
// }

// Approach1 : Exhaustive approach/exploring all the ways/BruteForce Approach
// Exceeding time limit because exponentially increasing time complexity
// class Solution {
//     int count; //this is global scope
//     public int change(int amount, int[] coins) {
//         //int[] count = new count[];                 
//         this.count = 0;
//         helper(coins,0, amount);
//         return count;   
//     }
//     private void helper(int[] coins, int i, int amount){
//         //base case
//         if(amount == 0 ){
//             count++;
//             return;
//         }
//         if(amount<0 || i == coins.length) return;

//         //dont choose scenario
//         helper(coins, i+1, amount); //moving to next coin, amount remains same since not choosing any coin

//         //choose scenario
//         helper(coins, i, amount-coins[i]); // remains at the sane coin, amount should be deducted 
//     }
// }
