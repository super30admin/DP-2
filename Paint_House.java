// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Not too many problems


// Your code here along with comments explaining your approach

public class Paint_House {

    public static int min_cost(int[][] cost){
        if(cost == null || cost.length == 0){
            return 0;
        }

        //start from bottom of matrix, and add min of possible solutions from row below to current row's value
        for(int i = cost.length - 2; i >= 0; i--){
            cost[i][0] = cost[i][0] + Math.min(cost[i+1][1], cost[i+1][2]);  //red
            cost[i][1] = cost[i][1] + Math.min(cost[i+1][0], cost[i+1][2]);  //green
            cost[i][2] = cost[i][2] + Math.min(cost[i+1][0], cost[i+1][1]);  //blue
        }
        
        //return min cost from all 3 paths
        return Math.min(cost[0][0], Math.min(cost[0][1], cost[0][2]));
    }

    public static void main(String[] args) {
        int [][] test = {{14,2,11},{11,14,5},{14,3,10}};
        System.out.println(min_cost(test));
    }
}