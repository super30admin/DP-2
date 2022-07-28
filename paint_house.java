// solution without dp array
//time complexity: o(mn)
//space complexity: o(1)

// class Solution{
//     public int minCost(int[][] costs){
//         if(costs == null || costs.length == 0) return 0;
//         int m = costs.length;
//         for(int i = m-2; i>= 0; i--){
//             costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
//             costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
//             costs[i][2] = costs[i][2] + Math.min(costs[i+1][1], costs[i+1][0]);
//         }
//          return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
//     }

// }


//solution with dp array
class Solution{
    public int minCost(int[][] costs){
        if(costs == null || costs.length == 0) return 0;
        int m = costs.length;
        int[][] dp = new int[m][3];
        for(int j = 0; j< 3; j++){
            dp[m-1][j] = costs[m-1][j];
        }
        for(int i = m-2; i>= 0; i--){
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][1], dp[i+1][0]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }

}








//Time Limit Exceeded
//time complexity: o(mn)
//space complexity: o(n)

// class Solution {
//     public int minCost(int[][] costs) {
//         if(costs == null || costs.length == 0) return 0;

//         // color mapping
//         //0--> red, 1--> green, 2--> blue
//         int red = helper(costs, 0, 0, 0);
//         int green = helper(costs, 0, 1, 0);
//         int blue = helper(costs, 0, 2, 0);

//         return Math.min(red, Math.min(green, blue));

//     }
//     private int helper (int[][] costs, int row, int color, int cost){
//         //base case

//         if(row == costs.length){
//             return cost;
//         }


//         //logic
//         if(color==0){
//             return Math.min(helper(costs, row+1, 1, cost + costs[row][0]), helper(costs, row+1, 2, cost + costs[row][0]));
//         }
//         if(color==1){
//             return Math.min(helper(costs, row+1, 0, cost + costs[row][1]), helper(costs, row+1, 2, cost + costs[row][1]));
//         }
//         if(color==2){
//             return Math.min(helper(costs, row+1, 0, cost + costs[row][2]), helper(costs, row+1, 1, cost + costs[row][2]));
//         }
//         return 54;
//     }

// }