// Time Complexity : O(n*m)
// Space Complexity : SC=O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach: create dp[][] array to store min cost painting at that place. Copy last row of costs[][] in dp[][] sine last house wont have option to choose. then loop from bottom to top in costs matrix. 0-R, 1-B, 2-G, dp[i][0]=costs[i][0] + min(dp[i+1][1],dp[i+1][2]) and similarly for other colors as well. At the end, ans would be min value in 0th row of dp[][]., In optimal approach, we can use 3 variables for R,B,G color costs, and modify them in loop(keep previous values for R and B in temp for using other colors after changing value).

public class PaintHouse {
//    Approach 1 - Dynamic programming with bottom up traversal in for loop in 2D array
//    TC = O(n), SC = O(m*n), here n=3 so O(m), m=no of houses
    //     public int minCost(int[][] costs) {
//         int m = costs.length;
//         int n = costs[0].length;

// //this time we dont need extra 1 space in row and column.
//         int[][] dp = new int[m][n];
//         //intialize last row of dp matrix with same costs from costs matrix sinze last row wont have option of choosing
//         dp[m - 1][0] = costs[m - 1][0];
//         dp[m - 1][1] = costs[m - 1][1];
//         dp[m - 1][2] = costs[m - 1][2];

//         //traverse costs and dp array from bottom to up to get the answers
//         for(int i = m - 2; i >= 0; i--) {
//             //cost is calculated as cost at that place + min of cost of subtree of 2 other colors
//             dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
//             dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
//             dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
//         }

//         //return min from first row which contains total costs for each subtree for each color choice
//         return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
//     }

    //    Approach 2 - Optimized Dynamic programming with bottom up traversal in for loop with 3 variables
//    TC = O(n), SC = O(n), here n=3 colors so O(1)
    public int minCost(int[][] costs) {
        //0-R 1-B 2-G
        int m = costs.length;
        int n = costs[0].length;
        //intialize color variables for each color trees from last row of costs since they dont have choice of choosing
        int colorR = costs[m - 1][0];
        int colorB = costs[m - 1][1];
        int colorG = costs[m - 1][2];

        for(int i = m - 2; i >= 0; i--) {
            int tempR = colorR; //store previous values before updating it
            int tempB = colorB;
            colorR = costs[i][0] + Math.min(colorB, colorG);
            colorB = costs[i][1] + Math.min(tempR, colorG);
            colorG = costs[i][2] + Math.min(tempR, tempB);
        }
        return Math.min(colorR, Math.min(colorB, colorG));
    }

    public static void main(String[] args) {
        PaintHouse solution = new PaintHouse();

        int[][] costs1 = {
                {17, 2, 17},
                {16, 16, 5},
                {14, 3, 19}
        };
        System.out.println("Minimum cost (Example 1): " + solution.minCost(costs1));

        int[][] costs2 = {
                {7, 5, 10},
                {2, 2, 2}
        };
        System.out.println("Minimum cost (Example 2): " + solution.minCost(costs2));
    }
}
