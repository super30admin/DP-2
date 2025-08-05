// aprroach -  we have  two constraints here one being the coin array and the second being the target amount, so we are going with the DP Matrix here to solve the repeating sub problems in the recursion and I am using here the bottom up DP that is solving for small problems and building till we get to the large big problem.  so the rows of a matrix would represent each for zero coin for the 0th index, the first coin for the first index then the first and second coin for the second index and so on. the columns would be from each of the target amount being from 0 to amount. For each certain point in the matrix the cell represents the required amount with the coins available. For each cell we have to add the two choices choosing the coin and not using the coin, not choosing the coin comes from the cell directly on top of the present cell i.e the number of ways we could get a valid path from all the coins prior to this coin. Choosing the coin comes from the cell in the same row but we have to go to a column index - present coin .i.e If we chose the coin now we have all the available coins but the target amount is the current Target- coin which would be present in the same row.  then we add both the values and store the value in the current cell. By the time we reach the last cell we would have the total number of valid paths.
 //time complexity being O(m x n)  since we are traveling the entire Matrix.  M is number of rows and n is the length of each row.

//Space complexity O(m x n)  Since we are using m x n Matrix to store each of the possible combination

class Solution {
    public int change(int amount, int[] coins) {
        int n = amount;
        int m = coins.length;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for (int i = 1; i <m+1; i++) {
            for (int j = 0; j < n
            +1; j++) {
                if (j < coins[i-1])
                    dp[i][j] = dp[i - 1][j];//if the required amount is less than that current coin we cannot choose,so we eliminated the choose path.
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i-1]];
            }

        }
        return dp[m][n];
    }
}
