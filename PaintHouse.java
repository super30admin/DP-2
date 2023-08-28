// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


public class PaintHouse {

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


