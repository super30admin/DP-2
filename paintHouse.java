// Time Complexity : O (m)  where m is number of houses
// Space Complexity : O (1) no extra space if we update costs matrix itself, if we cannot mutate same matrix, then use dp matrix with extra space (m * n), m = num of houses, n = num of colors
// Did this code successfully run on Leetcode : -
// Any problem you faced while coding this : No

public class paintHouse {

    // public static int minCost(int [][] costs){

    //     int case1 = helper(costs, 0, 0, 0); // prevcolor RED
    //     int case2 = helper(costs, 0, 1, 0); // prevcolor BLUE
    //     int case3 = helper(costs, 0, 2, 0); // prevcolor GREEN

    //     return Math.min(case1, Math.min(case2, case3));
    // }

    // private static int helper(int[][] costs, int row, int currColor, int minCost){
        
    //     // base
    //     if(row == costs.length) return minCost;

    //     // logic
    //     if(currColor == 0){
    //         return Math.min(helper(costs, row + 1, 1, minCost + costs[row][0]), 
    //                         helper(costs, row + 1, 2, minCost + costs[row][0]));
    //     }
    //     if(currColor == 1){
    //         return Math.min(helper(costs, row + 1, 0, minCost + costs[row][1]), 
    //                         helper(costs, row + 1, 2, minCost + costs[row][1]));
    //     }
    //     if(currColor == 2){
    //         return Math.min(helper(costs, row + 1, 0, minCost + costs[row][2]), 
    //                         helper(costs, row + 1, 1, minCost + costs[row][2]));
    //     }
    //     return 0;
    // }

    public static int minCost(int[][] costs){
        if(costs == null || costs.length == 0) return 0;
        for(int i = costs.length - 2; i >= 0; i--){
            costs[i][0] += Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] += Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] += Math.min(costs[i+1][0], costs[i+1][1]);
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }

    public static void main(String[] args) {

        int[][] costs = {{17,2,17}, {16, 16, 5}, {14, 3,19}};
        System.out.println(minCost(costs));
        
    }
    
}
