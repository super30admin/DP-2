// Time Complexity : O(nm) where n is number of coins and m is the amount
// Space Complexity : O(nm) where n is number of coins and m is the amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* Approach:

*/
class PaintHouse{
    public static int minCost(int costs[][], int n) {
        if(n==0) return 0;
        int[][] dp = new int[n][3];

        //Base case: first row in dp is the costs[0]
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i = 1; i<n; i++){
            //If current house is R then take take min cost previous B and G houses
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2])+ costs[i][0];
            //If current house is B then take take min cost previous R and G houses
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2])+ costs[i][1];
            //If current house is G then take take min cost previous R and B houses
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1])+ costs[i][2];
        }

        return (Math.min(dp[n - 1][0],Math.min(dp[n - 1][1], dp[n - 1][2])));
    }

    public static void main(String[] args)
    {
 
        int costs[][] = { { 14, 2, 11 },
                          { 11, 14, 5 },
                          { 14, 3, 10 } };
 
        int N = 3;
 
        // Function Call
        System.out.println(minCost(costs, N));
    }
}