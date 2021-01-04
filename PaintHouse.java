// If input array is ALLOWED TO BE MODIFIED
// class Solution {
//     public int minCost(int[][] costs) {
//         if ( costs == null || costs.length == 0) 
//             return 0;
//         for(int i = costs.length-2; i>=0; i--)
//         {
//             costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
//             costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
//             costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);
//         }
//         // Return min of 1st row
//         return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
//     }  
// }

// If input array is NOT ALLOWED TO BE MODIFIED
class Solution {
    public int minCost(int[][] costs) {
        if ( costs == null || costs.length == 0) 
            return 0;
        int colorRed = costs[costs.length-1][0];
        int colorGreen = costs[costs.length-1][1];
        int colorBlue = costs[costs.length-1][2];
        
        for(int i = costs.length-2; i>=0; i--)
        {
            
            int prevRed = colorRed;
            int prevGreen = colorGreen;
            int prevBlue = colorBlue;
            colorRed = costs[i][0] + Math.min(prevGreen,prevBlue);
            colorGreen = costs[i][1] + Math.min(prevRed, prevBlue);
            colorBlue = costs[i][2] + Math.min(prevRed, prevGreen);
            
        }
        // Return min of 1st row
        return Math.min(colorRed, Math.min(colorGreen, colorBlue));
    }  
}

// Recursion 
// class Solution {
//     public int minCost(int[][] costs) {
//         int case1 = helper(costs, 0, 0, 0);
//         int case2 = helper(costs, 0, 1, 0);
//         int case3 = helper(costs, 0, 2, 0);
//         return Math.min(case1, Math.min(case2, case3));
//     }
    
//     private int helper(int[][] costs, int row, int color, int min)
//     {
//         //base case
//         if (row >= costs.length)
//             return min;
       
//         // logic 
//         if (color == 0)
//         {
//             return Math.min(helper(costs, row+1, 1, min + costs[row][0]),
//                             helper(costs, row+1, 2, min + costs[row][0]));
//         }
//        if (color == 1)
//         {
//             return Math.min(helper(costs, row+1, 0, min + costs[row][1]),
//                             helper(costs, row+1, 2, min + costs[row][1]));
//         }
//          return Math.min(helper(costs, row+1, 0, min + costs[row][2]),
//                          helper(costs, row+1, 1, min + costs[row][2]));
//     }
// }
