public class problem1 {


// Time Complexity : O(n)
// Space Complexity : O(1) n-> number of elements in given array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
    public int minCost(int[][] costs) {
        if(costs == null || costs.length==0) return 0;

        int n= costs.length;

        for(int i=n-2;i>=0;i--){
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1],costs[i+1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0],costs[i+1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][1],costs[i+1][0]);
        }

        int min = Integer.MAX_VALUE;
        for(int j=0;j<3;j++){
            min = Math.min(min,costs[0][j]);
        }
        return min;
    }
}
